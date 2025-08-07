package com.example.telikiergasiaekdosi3;

import android.app.TimePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DailyEntryActivity extends AppCompatActivity {

    EditText breakfastInput, snackInput, lunchInput, afternoonSnackInput, dinnerInput;
    EditText exerciseInput, sleepInput, weightInput;

    EditText breakfastTime,snackTime,lunchTime,afternoonSnackTime,dinnerTime,exerciseTime;
    TextView dateText;
    Button saveButton;
    DatabaseHelper dbHelper;
    String username, selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_entry);

        dbHelper = new DatabaseHelper(this);
        username = getIntent().getStringExtra("USERNAME");
        selectedDate = getIntent().getStringExtra("DATE");

        if (selectedDate == null) {
            String lastDate = dbHelper.getLastDateForUser(username);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

            if (lastDate != null) {
                try {
                    Date date = sdf.parse(lastDate);
                    // +1 μέρα
                    long nextDateMillis = date.getTime() + 24 * 60 * 60 * 1000;
                    selectedDate = sdf.format(new Date(nextDateMillis));
                } catch (Exception e) {
                    e.printStackTrace();
                    selectedDate = sdf.format(new Date()); // σήμερα
                }
            } else {
                selectedDate = sdf.format(new Date()); // καμία καταχώρηση ακόμα => σήμερα
            }
        }


        dateText = findViewById(R.id.date_text);
        dateText.setText("Ημερομηνία: " + "\n" + "\n" + selectedDate);

        breakfastInput = findViewById(R.id.breakfast_input);
        snackInput = findViewById(R.id.snack_input);
        lunchInput = findViewById(R.id.lunch_input);
        afternoonSnackInput = findViewById(R.id.afternoon_snack_input);
        dinnerInput = findViewById(R.id.dinner_input);
        exerciseInput = findViewById(R.id.exercise_input);
        sleepInput = findViewById(R.id.sleep_input);
        weightInput = findViewById(R.id.weight_input);

        breakfastTime = findViewById(R.id.breakfast_time);
        snackTime = findViewById(R.id.snack_time);
        lunchTime = findViewById(R.id.lunchTime);
        afternoonSnackTime = findViewById(R.id.afternoonSnackTime);
        dinnerTime = findViewById(R.id.dinnerTime);
        exerciseTime = findViewById(R.id.exerciseTime);

        breakfastTime.setOnClickListener(v -> showTimePicker(breakfastTime));
        snackTime.setOnClickListener(v -> showTimePicker(snackTime));
        lunchTime.setOnClickListener(v -> showTimePicker(lunchTime));
        afternoonSnackTime.setOnClickListener(v -> showTimePicker(afternoonSnackTime));
        dinnerTime.setOnClickListener(v -> showTimePicker(dinnerTime));



        saveButton = findViewById(R.id.save_button);

        // Αν υπάρχει ήδη καταχώρηση, εμφάνισέ την
        Cursor cursor = dbHelper.getRecordByDate(username, selectedDate);
        if (cursor != null && cursor.moveToFirst()) {
            breakfastInput.setText(cursor.getString(cursor.getColumnIndex("breakfast")));
            breakfastTime.setText(cursor.getString(cursor.getColumnIndex("breakfast_time")));

            snackInput.setText(cursor.getString(cursor.getColumnIndex("snack")));
            snackTime.setText(cursor.getString(cursor.getColumnIndex("snack_time")));

            lunchInput.setText(cursor.getString(cursor.getColumnIndex("lunch")));
            lunchTime.setText(cursor.getString(cursor.getColumnIndex("lunch_time")));

            afternoonSnackInput.setText(cursor.getString(cursor.getColumnIndex("afternoonSnack")));
            afternoonSnackTime.setText(cursor.getString(cursor.getColumnIndex("afternoonSnack_time")));

            dinnerInput.setText(cursor.getString(cursor.getColumnIndex("dinner")));
            dinnerTime.setText(cursor.getString(cursor.getColumnIndex("dinner_time")));

            exerciseInput.setText(cursor.getString(cursor.getColumnIndex("exercise")));
            exerciseTime.setText(cursor.getString(cursor.getColumnIndex("exercise_time")));

            sleepInput.setText(cursor.getString(cursor.getColumnIndex("sleep_hours")));
            weightInput.setText(cursor.getString(cursor.getColumnIndex("weight")));
        }


        saveButton.setOnClickListener(v -> {
            dbHelper.insertOrUpdateRecord(
                    username,
                    selectedDate,
                    breakfastInput.getText().toString(),
                    breakfastTime.getText().toString(),      // ώρα πρωινού
                    snackInput.getText().toString(),
                    snackTime.getText().toString(),          // ώρα δεκατιανού
                    lunchInput.getText().toString(),
                    lunchTime.getText().toString(),          // ώρα μεσημεριανού
                    afternoonSnackInput.getText().toString(),
                    afternoonSnackTime.getText().toString(), // ώρα απογευματινού
                    dinnerInput.getText().toString(),
                    dinnerTime.getText().toString(),         // ώρα βραδινού
                    exerciseInput.getText().toString(),
                    exerciseTime.getText().toString(),       // διάρκεια άσκησης
                    sleepInput.getText().toString(),
                    weightInput.getText().toString()
            );
            Toast.makeText(this, "Ημέρα αποθηκεύτηκε!", Toast.LENGTH_SHORT).show();
            finish();
        });

    }


    private void showTimePicker(EditText target) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        new TimePickerDialog(this, (view, hourOfDay, minute1) -> {
            String time = String.format("%02d:%02d", hourOfDay, minute1);
            target.setText(time);
        }, hour, minute, true).show();
    }
}

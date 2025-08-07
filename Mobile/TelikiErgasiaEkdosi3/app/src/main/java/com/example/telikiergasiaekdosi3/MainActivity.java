package com.example.telikiergasiaekdosi3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView recordsListView;
    Button addRecordButton;
    DatabaseHelper dbHelper;
    String username;
    ArrayList<String> recordSummaries = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = getIntent().getStringExtra("USERNAME");
        dbHelper = new DatabaseHelper(this);

        recordsListView = findViewById(R.id.records_list);
        addRecordButton = findViewById(R.id.add_record_button);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recordSummaries);
        recordsListView.setAdapter(adapter);

        loadRecords();

        addRecordButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, DailyEntryActivity.class);
            intent.putExtra("USERNAME", username);
            startActivity(intent);
        });

        recordsListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedDate = recordSummaries.get(position).split(" ")[0]; // π.χ. 2025-05-28
            Intent intent = new Intent(this, DailyEntryActivity.class);
            intent.putExtra("USERNAME", username); //περνάει το username στο DailyEntryActivity
            intent.putExtra("DATE", selectedDate); //περνάει η ημερομηνία στο DailyEntryActivity
            startActivity(intent);
        });

        Button reportButton = findViewById(R.id.report_button);

        reportButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ReportActivity.class);
            intent.putExtra("USERNAME", username);
            startActivity(intent);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadRecords();
    }

    private void loadRecords() {
        recordSummaries.clear();
        Cursor cursor = dbHelper.getRecordsByUsername(username);
        if (cursor.moveToFirst()) {
            do {
                String date = cursor.getString(cursor.getColumnIndex("date"));
                String summary = date;
                recordSummaries.add(summary);
            } while (cursor.moveToNext());
        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }
}

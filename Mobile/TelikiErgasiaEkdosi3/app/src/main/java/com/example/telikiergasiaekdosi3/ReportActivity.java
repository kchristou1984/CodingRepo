package com.example.telikiergasiaekdosi3;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.*;
import android.Manifest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class ReportActivity extends AppCompatActivity {

    EditText fromDateInput, toDateInput;
    Button generateButton, btnExportPDF,  btnExportTxt, btnExportExcel;
    ListView reportListView;
    DatabaseHelper dbHelper;
    String username;
    ArrayAdapter<String> adapter;
    ArrayList<String> summaries = new ArrayList<>();
    Spinner reportTypeSpinner;




    private static final int REQUEST_CODE_OPEN_FILE = 1;
    private static final int REQUEST_CODE_SAVE_FILE = 2;
    private static final int REQUEST_CODE_EXPORT_PDF = 3;
    private static final int REQUEST_CODE_EXPORT_EXCEL = 4;
    private static final int REQUEST_WRITE_STORAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        fromDateInput = findViewById(R.id.from_date_input);
        toDateInput = findViewById(R.id.to_date_input);
        generateButton = findViewById(R.id.generate_button);
        reportListView = findViewById(R.id.report_list_view);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, summaries);
        reportListView.setAdapter(adapter);

        dbHelper = new DatabaseHelper(this);
        username = getIntent().getStringExtra("USERNAME");

        fromDateInput.setOnClickListener(v -> showDatePicker(fromDateInput));
        toDateInput.setOnClickListener(v -> showDatePicker(toDateInput));

        generateButton.setOnClickListener(v -> generateReport());


        btnExportPDF = findViewById(R.id.btnExportPDF);
        checkPermissions();
        btnExportPDF.setOnClickListener(v -> exportToPDF());

        btnExportTxt = findViewById(R.id.btnExportTxt);
        checkPermissions();
        btnExportTxt.setOnClickListener(v -> exportToTxt());


        btnExportExcel = findViewById(R.id.btnExportExcel);
        checkPermissions();
        btnExportExcel.setOnClickListener(v -> exportToExcel());

        reportTypeSpinner = findViewById(R.id.report_type_spinner);
    }

        private void checkPermissions() {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_WRITE_STORAGE);
            }
        }

    private void exportToExcel() {
        // Δημιουργία ονόματος αρχείου με ημερομηνία
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String fileName = "Note_" + timeStamp + ".xlsx";


        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        intent.putExtra(Intent.EXTRA_TITLE, fileName);
        startActivityForResult(intent, REQUEST_CODE_EXPORT_EXCEL);
    }

    private void createExcelFile(Uri uri) {
        try {
            // Create a new workbook
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Αναφορά");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Ημερομηνία");
            header.createCell(1).setCellValue("Πρωινό");
            header.createCell(2).setCellValue("Ώρα πρωϊνου");
            header.createCell(3).setCellValue("Δεκατιανό");
            header.createCell(4).setCellValue("Ώρα δεκατιανού");
            header.createCell(5).setCellValue("Μεσημεριανό");
            header.createCell(6).setCellValue("Ώρα μεσημεριανού");
            header.createCell(7).setCellValue("Απογευματινό");
            header.createCell(8).setCellValue("Ώρα απογευματινού");
            header.createCell(9).setCellValue("Βραδυνό");
            header.createCell(10).setCellValue("Ώρα βραδυνού");
            header.createCell(11).setCellValue("Βάρος");
            header.createCell(12).setCellValue("Είδος άσκησης");
            header.createCell(13).setCellValue("Διάρκεια άσκησης");

            String start = fromDateInput.getText().toString();
            String end = toDateInput.getText().toString();
            Cursor cursor = dbHelper.getRecordsByDateRange(username, start, end);

            int rowIndex = 1;

            if (cursor.moveToFirst()) {
                do {
                    Row row = sheet.createRow(rowIndex++);

                    row.createCell(0).setCellValue(cursor.getString(cursor.getColumnIndex("date")));
                    row.createCell(1).setCellValue(cursor.getString(cursor.getColumnIndex("breakfast")));
                    row.createCell(2).setCellValue(cursor.getString(cursor.getColumnIndex("breakfast_time")));
                    row.createCell(3).setCellValue(cursor.getString(cursor.getColumnIndex("snack")));
                    row.createCell(4).setCellValue(cursor.getString(cursor.getColumnIndex("snack_time")));
                    row.createCell(5).setCellValue(cursor.getString(cursor.getColumnIndex("lunch")));
                    row.createCell(6).setCellValue(cursor.getString(cursor.getColumnIndex("lunch_time")));
                    row.createCell(7).setCellValue(cursor.getString(cursor.getColumnIndex("afternoonSnack")));
                    row.createCell(8).setCellValue(cursor.getString(cursor.getColumnIndex("afternoonSnack_time")));
                    row.createCell(9).setCellValue(cursor.getString(cursor.getColumnIndex("dinner")));
                    row.createCell(10).setCellValue(cursor.getString(cursor.getColumnIndex("dinner_time")));
                    row.createCell(11).setCellValue(cursor.getString(cursor.getColumnIndex("weight")));
                    row.createCell(12).setCellValue(cursor.getString(cursor.getColumnIndex("exercise")));
                    row.createCell(13).setCellValue(cursor.getString(cursor.getColumnIndex("exercise_time")));

                } while (cursor.moveToNext());
            } else {
                Toast.makeText(this, "Δεν βρέθηκαν δεδομένα για εξαγωγή.", Toast.LENGTH_SHORT).show();
            }

            cursor.close();

            OutputStream outputStream = getContentResolver().openOutputStream(uri);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

            Toast.makeText(this, "Excel file created:\n",Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error creating Excel file:\n" ,Toast.LENGTH_LONG).show();
        }
    }



    private void exportToPDF() {
        // Δημιουργία ονόματος αρχείου με ημερομηνία
        String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss", Locale.getDefault()).format(new Date());
        String fileName = "Note_" + timeStamp + ".pdf";


        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/pdf");
        intent.putExtra(Intent.EXTRA_TITLE, fileName);
        startActivityForResult(intent, REQUEST_CODE_EXPORT_PDF);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && data != null) {
            Uri uri = data.getData();
            if (uri == null) return;

            try {
                if (requestCode == REQUEST_CODE_EXPORT_PDF) {
                    createPDF(uri);
                } else if (requestCode == REQUEST_CODE_SAVE_FILE) {
                    saveTxtContent(uri);
                } else if (requestCode == REQUEST_CODE_EXPORT_EXCEL) {
                    createExcelFile(uri);
                }
                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(this, "Σφάλμα: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
    }


    private void createPDF(Uri uri) {
        Document document = new Document();
        try {
            OutputStream outputStream = getContentResolver().openOutputStream(uri);
            PdfWriter.getInstance(document, outputStream);
            document.open();

            BaseFont baseFont = BaseFont.createFont("assets/fonts/DejaVuSans.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(baseFont, 12, Font.NORMAL);
            for (String summary : summaries) {
                document.add(new Paragraph(summary + "\n\n", font));
            }
            document.close();
            Toast.makeText(this, "PDF δημιουργήθηκε επιτυχώς", Toast.LENGTH_SHORT).show();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Σφάλμα δημιουργίας PDF", Toast.LENGTH_SHORT).show();
        }
    }

    private void exportToTxt() {

        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TITLE, "note_" + System.currentTimeMillis() + ".txt");
        startActivityForResult(intent, REQUEST_CODE_SAVE_FILE);
    }

    private void saveTxtContent(Uri uri) {
        try {
            FileOutputStream outputStream = (FileOutputStream) getContentResolver().openOutputStream(uri);
            StringBuilder sb = new StringBuilder();
            for (String summary : summaries) {
                sb.append(summary).append("\n\n");
            }
            outputStream.write(sb.toString().getBytes(StandardCharsets.UTF_8));
            Toast.makeText(this, "Αποθηκεύτηκε το αρχείο", Toast.LENGTH_SHORT).show();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Σφάλμα κατά την αποθήκευση του αρχείου", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == ReportActivity.REQUEST_WRITE_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Δικαιώματα αποθηκευσης δεδομένων", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Απορρίφθηκαν τα δικαιώματα αποθήκευσης", Toast.LENGTH_SHORT).show();
            }
        }
    }



    private void showDatePicker(EditText target) {
        Calendar calendar = Calendar.getInstance();
        new DatePickerDialog(this,
                (view, year, month, dayOfMonth) -> {
                    String date = String.format("%04d-%02d-%02d", year, month + 1, dayOfMonth);
                    target.setText(date);
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        ).show();
    }

    private void generateReport() {

        String selectedType = reportTypeSpinner.getSelectedItem().toString();

        String start = "";
        String end = "";

        switch (selectedType) {
            case "Ημερήσια":
                start = fromDateInput.getText().toString();
                end = start; // ίδια μέρα
                break;
            case "Εβδομαδιαία":
                start = fromDateInput.getText().toString();
                end = getWeek(start);
                break;
            case "Καθορισμένο διάστημα":
                start = fromDateInput.getText().toString();
                end = toDateInput.getText().toString();
                break;
        }

        if (start.isEmpty() || end.isEmpty()) {
            Toast.makeText(this, "Παρακαλώ συμπλήρωσε και τις δύο ημερομηνίες.", Toast.LENGTH_SHORT).show();
            return;
        }

        summaries.clear();
        Cursor cursor = dbHelper.getRecordsByDateRange(username, start, end);
        int dayCount = 1;
        if (cursor.moveToFirst()) {
            do {
                String date = cursor.getString(cursor.getColumnIndex("date"));
                String breakfast = cursor.getString(cursor.getColumnIndex("breakfast"));
                String lunch = cursor.getString(cursor.getColumnIndex("lunch"));
                String dinner = cursor.getString(cursor.getColumnIndex("dinner"));
                String weight = cursor.getString(cursor.getColumnIndex("weight"));
                String snack = cursor.getString(cursor.getColumnIndex("snack"));
                String snackTime = cursor.getString(cursor.getColumnIndex("snack_time"));
                String breakfastTime = cursor.getString(cursor.getColumnIndex("breakfast_time"));
                String afternoonSnack = cursor.getString(cursor.getColumnIndex("afternoonSnack"));
                String afternoonSnackTime = cursor.getString(cursor.getColumnIndex("afternoonSnack_time"));
                String lunchTime = cursor.getString(cursor.getColumnIndex("lunch_time"));
                String dinnerTime = cursor.getString(cursor.getColumnIndex("dinner_time"));
                String exercise = cursor.getString(cursor.getColumnIndex("exercise"));
                String exerciseTime = cursor.getString(cursor.getColumnIndex("exercise_time"));

                summaries.add(dayCount+"η Μέρα" + "(" + date + ")" + "\n" +  "Πρωινό: " + breakfast + " | Ώρα: " + breakfastTime + "\n" + "Δεκατιανό: " + snack + " | Ώρα: " + snackTime + "\n" +  "Μεσημεριανό: " + lunch + " | Ώρα: " + lunchTime + "\n" +  "Απογευματινό: " + afternoonSnack + " | Ώρα: " + afternoonSnackTime + "\n" +  "Βραδινό: " + dinner + " Ώρα: " + dinnerTime + "\n" + "Βάρος: " + weight + "\n" + "Άσκηση: "+ exercise + " | Διάρκεια: " + exerciseTime);
                dayCount++;
            } while (cursor.moveToNext());
        } else {
            summaries.add("Δεν βρέθηκαν δεδομένα για το διάστημα.");
        }

        cursor.close();
        adapter.notifyDataSetChanged();
    }

    private String getWeek(String startDateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            Date startDate = sdf.parse(startDateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.DAY_OF_MONTH, 6);
            return sdf.format(calendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return startDateStr;
        }
    }

}

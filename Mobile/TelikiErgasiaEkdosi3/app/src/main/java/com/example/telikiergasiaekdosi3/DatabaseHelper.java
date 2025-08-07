package com.example.telikiergasiaekdosi3;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "NutritionTracker.db";
    private static final int DATABASE_VERSION = 4;

    public static final String TABLE_RECORDS = "Records";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_RECORDS + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT NOT NULL," +
                "date TEXT NOT NULL," +
                "breakfast TEXT," +
                "breakfast_time TEXT," +
                "snack TEXT," +
                "snack_time TEXT," +
                "lunch TEXT," +
                "lunch_time TEXT," +
                "afternoonSnack TEXT," +
                "afternoonSnack_time TEXT," +
                "dinner TEXT," +
                "dinner_time TEXT," +
                "exercise TEXT," +
                "exercise_time TEXT," +
                "sleep_hours TEXT," +
                "weight TEXT," +
                "UNIQUE(username, date)" +
                ")";
        db.execSQL(createTable);


        String createCustomersTable = "CREATE TABLE IF NOT EXISTS customers (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT UNIQUE," +
                "password TEXT" +
                ");";
        db.execSQL(createCustomersTable);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECORDS);
        onCreate(db);
    }

    public Cursor getRecordsByUsername(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_RECORDS + " WHERE username = ? ORDER BY date ASC", new String[]{username});
    }

    public Cursor getRecordByDate(String username, String date) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_RECORDS + " WHERE username = ? AND date = ?", new String[]{username, date});
    }
//Εισαγωγή ή τροποποίηση εγγραφής
    public boolean insertOrUpdateRecord(String username, String date, String breakfast, String breakfastTime,
                                        String snack, String snackTime, String lunch, String lunchTime,
                                        String afternoonSnack, String afternoonSnackTime,
                                        String dinner, String dinnerTime,
                                        String exercise, String exerciseTime,
                                        String sleepHours, String weight) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("date", date);
        values.put("breakfast", breakfast);
        values.put("breakfast_time", breakfastTime);
        values.put("snack", snack);
        values.put("snack_time", snackTime);
        values.put("lunch", lunch);
        values.put("lunch_time", lunchTime);
        values.put("afternoonSnack", afternoonSnack);
        values.put("afternoonSnack_time", afternoonSnackTime);
        values.put("dinner", dinner);
        values.put("dinner_time", dinnerTime);
        values.put("exercise", exercise);
        values.put("exercise_time", exerciseTime);
        values.put("sleep_hours", sleepHours);
        values.put("weight", weight);

        // Έλεγχος αν υπάρχει ήδη εγγραφή
        Cursor cursor = db.rawQuery("SELECT id FROM " + TABLE_RECORDS + " WHERE username=? AND date=?",
                new String[]{username, date});

        if (cursor != null && cursor.moveToFirst()) {
            // Υπάρχει, γίνεται update
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            cursor.close();
            int rows = db.update(TABLE_RECORDS, values, "id=?", new String[]{String.valueOf(id)});
            return rows > 0;
        } else {
            // Δεν υπάρχει, γινεται insert
            if (cursor != null) cursor.close();
            long rowId = db.insert(TABLE_RECORDS, null, values);
            return rowId != -1;
        }
    }

    public String getLastDateForUser(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT date FROM " + TABLE_RECORDS + " WHERE username = ? ORDER BY date DESC LIMIT 1",
                new String[]{username}
        );
        if (cursor.moveToFirst()) {
            String lastDate = cursor.getString(0);
            cursor.close();
            return lastDate;
        }
        cursor.close();
        return null;
    }

    public Cursor getRecordsByDateRange(String username, String startDate, String endDate) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(
                "SELECT * FROM " + TABLE_RECORDS + " WHERE username = ? AND date BETWEEN ? AND ? ORDER BY date ASC",
                new String[]{username, startDate, endDate}
        );
    }

}

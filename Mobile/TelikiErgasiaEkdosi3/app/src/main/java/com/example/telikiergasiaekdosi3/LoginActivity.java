package com.example.telikiergasiaekdosi3;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText usernameInput, passwordInput;
    Button loginButton, registerButton;
    SQLiteDatabase db;  // Δηλώνουμε την βάση δεδομένων
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInput = findViewById(R.id.editTextUsername);
        passwordInput = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.buttonLogin);
        registerButton = findViewById(R.id.buttonRegister);

        // Δημιουργία ή άνοιγμα της βάσης δεδομένων
        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getWritableDatabase();

        //Login
        loginButton.setOnClickListener(v -> {
            String username = usernameInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();

            if (!username.isEmpty() && !password.isEmpty()) {
                // Έλεγχος αν τα στοιχεία είναι σωστά
                if (checkLogin(username, password)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("USERNAME", username);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "Λάθος όνομα χρήστη ή κωδικός", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Εισάγετε όνομα χρήστη και κωδικό", Toast.LENGTH_SHORT).show();
            }
        });

        // Eγγραφή χρήστη
        registerButton.setOnClickListener(v -> {
            String username = usernameInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();

            if (!username.isEmpty() && !password.isEmpty()) {
                // Έλεγχος αν το όνομα χρήστη υπάρχει ήδη
                if (checkIfUserExists(username)) {
                    Toast.makeText(this, "Αυτό το όνομα χρήστη υπάρχει ήδη", Toast.LENGTH_SHORT).show();
                } else {
                    // Εισαγωγή νέου χρήστη στη βάση
                    insertUser(username, password);
                    Toast.makeText(this, "Η εγγραφή ήταν επιτυχής!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Εισάγετε όνομα χρήστη και κωδικό", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Μέθοδος για το αν υπάρχει το όνομα χρήστη
    private boolean checkIfUserExists(String username) {
        Cursor cursor = db.rawQuery("SELECT * FROM customers WHERE username=?", new String[]{username});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

    // Μέθοδος για τον έλεγχο του login
    private boolean checkLogin(String username, String password) {
        Cursor cursor = db.rawQuery("SELECT * FROM customers WHERE username=? AND password=?", new String[]{username, password});
        boolean validLogin = cursor.getCount() > 0;
        cursor.close();
        return validLogin;
    }

    // Μέθοδος για την εισαγωγή νέου χρήστη στη βάση
    private void insertUser(String username, String password) {
        try {
            db.execSQL("INSERT INTO customers(username, password) VALUES(?, ?)", new Object[]{username, password});
        } catch (SQLException e) {
            Toast.makeText(this, "Σφάλμα κατά την εγγραφή", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (db != null) {
            db.close();  // Κλείσιμο της βάσης δεδομένων
        }
    }
}

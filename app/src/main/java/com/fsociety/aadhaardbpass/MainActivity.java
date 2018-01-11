package com.fsociety.aadhaardbpass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView databasePassword = findViewById(R.id.db_password);
        TextView encodedDatabasePassword = findViewById(R.id.db_password_encoded);

        String password = generateDBPassword();
        databasePassword.setText("Database password = " + password);
        encodedDatabasePassword.setText("Encoded database password = " + encodeBase64(password));
    }

    private static String generateDBPassword() {
        Random random = new Random();
        random.setSeed(123456789);
        return "db_password_123" + random.nextInt(10);
    }

    public static String encodeBase64(String str) {
        return Base64.encodeToString(str.getBytes(), 2);
    }
}

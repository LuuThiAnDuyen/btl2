package com.example.practice_62;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editTextDatabaseName;
    Button buttonCreateDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDatabaseName = findViewById(R.id.editTextDatabaseName);
        buttonCreateDatabase = findViewById(R.id.buttonCreateDatabase);

        buttonCreateDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String databaseName = editTextDatabaseName.getText().toString().trim();
                if (!databaseName.isEmpty()) {
                    try {
                        DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this, databaseName);
                        dbHelper.getWritableDatabase(); // Tạo cơ sở dữ liệu
                        Toast.makeText(MainActivity.this, "Database " + databaseName + " created successfully!", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Failed to create database", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a database name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
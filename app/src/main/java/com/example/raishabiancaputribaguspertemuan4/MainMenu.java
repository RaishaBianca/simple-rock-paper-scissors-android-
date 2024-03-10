package com.example.raishabiancaputribaguspertemuan4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        // Receive data from Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("key");

        // Display received data in TextView
        TextView greetingTextView = findViewById(R.id.greetingTextView);
        String greetingMessage = String.format(getString(R.string.greeting_template), name);
        greetingTextView.setText(greetingMessage);
    }
}


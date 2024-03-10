package com.example.raishabiancaputribaguspertemuan4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        Button playButton = findViewById(R.id.startButton);

        playButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainMenu.this, Game.class);
                startActivity(intent);
            }
        });
    }
}

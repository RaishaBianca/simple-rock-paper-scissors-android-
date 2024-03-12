package com.example.raishabiancaputribaguspertemuan4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinishGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);

        Intent intent = getIntent();
        String status = intent.getStringExtra("status");

        TextView statusView = findViewById(R.id.status);
        statusView.setText(status);

        Button restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener(v -> {
            Intent intent1 = new Intent(FinishGame.this, Game.class);
            startActivity(intent1);
        });
    }


}

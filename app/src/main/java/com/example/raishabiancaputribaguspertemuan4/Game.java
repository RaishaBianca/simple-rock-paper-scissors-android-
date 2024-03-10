package com.example.raishabiancaputribaguspertemuan4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Game extends AppCompatActivity{

    private static final int ROCK = 0;
    private static final int PAPER = 1;
    private static final int SCISSORS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_menu);
        Button rockButton = findViewById(R.id.rockButton);
        Button paperButton = findViewById(R.id.paperButton);
        Button scissorsButton = findViewById(R.id.scissorsButton);

        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame(ROCK);
            }
        });

        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame(PAPER);
            }
        });

        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame(SCISSORS);
            }
        });

        if (savedInstanceState != null) {
            String desc = savedInstanceState.getString("desc");
            String compMove = savedInstanceState.getString("compMove");
            TextView descTextView = findViewById(R.id.desc);
            TextView compMoveTextView = findViewById(R.id.computerMove);
            descTextView.setText(desc);
            compMoveTextView.setText(compMove);
        }
    }

    void playGame(int playerChoice) {
        int computerChoice = (int) (Math.random() * 3);

        String[] moves = {"Rock", "Paper", "Scissors"};

        String compMoveString = moves[computerChoice];

        String result;
        if (playerChoice == computerChoice) {
            result = "It's a tie!";
        } else if ((playerChoice == ROCK && computerChoice == SCISSORS) ||
                (playerChoice == PAPER && computerChoice == ROCK) ||
                (playerChoice == SCISSORS && computerChoice == PAPER)) {
            result = "You win!";
        } else {
            result = "Computer wins!";
        }

        TextView descTextView = findViewById(R.id.desc);
        descTextView.setText(result);

        TextView compMoveTextView = findViewById(R.id.computerMove);
        compMoveTextView.setText(String.format("Computer chose: %s", compMoveString));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView descTextView = findViewById(R.id.desc);
        TextView compMoveTextView = findViewById(R.id.computerMove);
        outState.putString("desc", descTextView.getText().toString());
        outState.putString("compMove", compMoveTextView.getText().toString());
    }

}



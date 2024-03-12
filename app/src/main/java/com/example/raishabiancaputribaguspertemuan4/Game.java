package com.example.raishabiancaputribaguspertemuan4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Game extends AppCompatActivity {

    private static final int ROCK = 0;
    private static final int PAPER = 1;
    private static final int SCISSORS = 2;
    private static int Tries = 0;
    private static final int Round = 3;
    private int computerScore = 0, playerScore = 0;
    private String status = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_menu);
        Button rockButton = findViewById(R.id.rockButton);
        Button paperButton = findViewById(R.id.paperButton);
        Button scissorsButton = findViewById(R.id.scissorsButton);

        rockButton.setOnClickListener(v -> playGame(ROCK));
        paperButton.setOnClickListener(v -> playGame(PAPER));
        scissorsButton.setOnClickListener(v -> playGame(SCISSORS));

        if (savedInstanceState != null) {
            String desc = savedInstanceState.getString("desc");
            String compMove = savedInstanceState.getString("compMove");
            TextView descTextView = findViewById(R.id.desc);
            TextView compMoveTextView = findViewById(R.id.computerMove);
            descTextView.setText(desc);
            compMoveTextView.setText(compMove);
            status = savedInstanceState.getString("status");
        }

        checkAndAddFinishButton();
    }

    void playGame(int playerChoice) {

        int computerChoice = (int) (Math.random() * 3);

        String[] moves = {"Rock", "Paper", "Scissors"};

        String compMoveString = moves[computerChoice];

        if (playerChoice == computerChoice) {
            playerScore += 0;
            computerScore += 0;
        } else if ((playerChoice == ROCK && computerChoice == SCISSORS) ||
                (playerChoice == PAPER && computerChoice == ROCK) ||
                (playerChoice == SCISSORS && computerChoice == PAPER)) {
            playerScore += 1;
        } else {
            computerScore += 1;
        }

        TextView descTextView = findViewById(R.id.desc);
        descTextView.setText(String.format("Player: %d Computer: %d", playerScore, computerScore));

        TextView compMoveTextView = findViewById(R.id.computerMove);
        compMoveTextView.setText(String.format("Computer chose: %s", compMoveString));

        Tries += 1;

        checkAndAddFinishButton();
    }

    private void checkAndAddFinishButton() {
        if (Tries >= Round) {
            if (playerScore > computerScore) {
                status = "Player Win";
            } else if (playerScore < computerScore) {
                status = "Computer Win";
            }

            findViewById(R.id.rockButton).setEnabled(false);
            findViewById(R.id.paperButton).setEnabled(false);
            findViewById(R.id.scissorsButton).setEnabled(false);

            Button finishButton = new Button(this);
            finishButton.setText(R.string.finish);
            finishButton.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    )
            );
            finishButton.setOnClickListener(v -> {
                Intent intent = new Intent(Game.this, FinishGame.class);
                intent.putExtra("status", status);
                startActivity(intent);
            });

            LinearLayout layout = findViewById(R.id.finishButtonContainer);
            layout.addView(finishButton);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView descTextView = findViewById(R.id.desc);
        TextView compMoveTextView = findViewById(R.id.computerMove);
        outState.putString("desc", descTextView.getText().toString());
        outState.putString("compMove", compMoveTextView.getText().toString());
        outState.putString("status", status);
    }
}

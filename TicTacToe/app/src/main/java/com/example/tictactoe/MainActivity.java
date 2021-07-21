package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Boolean gameActive = true;
    int activePlayer = 0;
    int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winposition = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public void tap(View view) {
        ImageView img = (ImageView) view;
        int tapimage = Integer.parseInt(img.getTag().toString()) ;
        if (!gameActive) {
            gameReset(view);
        }
        if (gamestate[tapimage] == 2 && gameActive) {
            gamestate[tapimage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView turn = findViewById(R.id.turn);
                turn.setText("O's Turn - Tap to Play");
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView turn = findViewById(R.id.turn);
                turn.setText("X's Turn - Tap to Play");
            }
            img.animate().translationYBy(1000f).setDuration(50);


        }

        for (int[] winpositions : winposition) {
            if (gamestate[winpositions[0]] == gamestate[winpositions[1]] && gamestate[winpositions[1]] == gamestate[winpositions[2]] && gamestate[winpositions[0]] != 2) {
                String winnerStr;
                gameActive = false;
                if(gamestate[winpositions[0]] == 0){
                    winnerStr = "X has won";
                }
                else{
                    winnerStr = "O has won";
                }
                TextView status = findViewById(R.id.turn);
                status.setText(winnerStr
                +" Tap to play again");

            }
        }
    }

    public void gameReset(View view) {
        gameActive = true;
        activePlayer = 0;
        for (int i = 0; i < gamestate.length; i++) {
            gamestate[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView turn = findViewById(R.id.turn);
        turn.setText("X's Turn - Tap to Play");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
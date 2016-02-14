package edu.upenn.cis350.hwk2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        int boardSize = getIntent().getExtras().getInt("BOARDSIZE");
        System.out.println(boardSize);
    }


}
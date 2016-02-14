package edu.upenn.cis350.hwk2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSpinner();

    }
    public void onQuitButtonClick(){

    }

    public void onPlayButtonClick(){
        Intent i = new Intent(this, GameActivity.class);
        startActivityForResult(i, GameActivity_ID);
        i.putExtra("BOARDSIZE",boardSize);
        startActivityForResult(i, GameActivity_ID);


    }
    private static final int GameActivity_ID = 1;
    private static int boardSize = 0;

    public void initSpinner() {
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        String text = mySpinner.getSelectedItem().toString();
        System.out.println(text);
    }
}

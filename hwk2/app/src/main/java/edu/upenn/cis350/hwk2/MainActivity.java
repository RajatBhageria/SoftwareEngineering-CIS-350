package edu.upenn.cis350.hwk2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSpinner();
    }
    public void onQuitButtonClick(View view){
        finish();
        System.exit(0);
    }

    public void onPlayButtonClick(View view){
        Intent i = new Intent(this, GameActivity.class);
        i.putExtra("BOARDSIZE", boardSize);
        startActivity(i);
    }
    private static String boardSize ="";

    public void initSpinner() {
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        //boardSize = mySpinner.getSelectedItem().toString();
        //Log.v("Size",boardSize);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                boardSize = (String) parent.getItemAtPosition(pos);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}

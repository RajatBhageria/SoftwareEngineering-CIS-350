package edu.upenn.cis350.hwk2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
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
    private final Spinner spinner = (Spinner) findViewById(R.id.spinner);
    private static final int GameActivity_ID = 1;
    private Button spinnerButton = (Button) findViewById(R.id.play);
    private static int boardSize = 0;

    public void initSpinner() {
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        String text = mySpinner.getSelectedItem().toString();
        System.out.println(text);
    }
}

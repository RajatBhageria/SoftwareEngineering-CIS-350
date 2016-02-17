package edu.upenn.cis350.hwk2;

import android.hardware.SensorEvent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity {

    private String data = "";
    public static int boardSize = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                data= null;
            } else {
                data= extras.getString("BOARDSIZE");
            }
        } else {
            data= (String)savedInstanceState.getSerializable("BOARDSIZE");
        }
        System.out.println("size of the board is:" + data);
        boardSize = Integer.parseInt(data);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.undo:
                Button undoButton = (Button) findViewById(R.id.undo);
                undoButton.setOnClickListener( new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                       // ((GameView) v).removeLastLine();
                    }
                });
                return true;

            case R.id.clear:
                Button clearButton = (Button) findViewById(R.id.clear);
                clearButton.setOnClickListener( new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        ((GameView) v).clearEverything();
                    }
                });
                return true;

            case R.id.quit:
                Button quitButton = (Button) findViewById(R.id.quit);
                quitButton.setOnClickListener( new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        finish();
                        System.exit(0);
                    }
                });
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
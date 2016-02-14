package edu.upenn.cis350.hwk2;

import android.hardware.SensorEvent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class GameActivity extends AppCompatActivity {

    private String data = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.v("Here", "here");
        //setContentView(new GameView(this));
        setContentView(R.layout.activity_game);
        data = getIntent().getStringExtra("BOARDSIZE");
        System.out.println(data);
        //int boardSize = Integer.parseInt(data);

    }

    /*private View mCustomView;
    public void onSensorChanged(SensorEvent event) {
        float[] values = event.values;
        mCustomView.setValues(values);    //pass the collected values to the view via setter
    }*/


}
package edu.upenn.cis350.hwk2;

import android.hardware.SensorEvent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class GameActivity extends AppCompatActivity {

    private String data = "";
    public static int boardSize = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.v("Here", "here");
        //setContentView(new GameView(this));
        setContentView(R.layout.activity_game);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                data= null;
            } else {
                data= extras.getString("BOARDSIZE");
            }
        } else {
            data= (String) savedInstanceState.getSerializable("BOARDSIZE");
        }
        System.out.println("size of the board is:" + data);
        boardSize = Integer.parseInt(data);
        System.out.println(boardSize);

    }

    /*private View mCustomView;
    public void onSensorChanged(SensorEvent event) {
        float[] values = event.values;
        mCustomView.setValues(values);    //pass the collected values to the view via setter
    }*/

    public int getBoardSize(){
        return boardSize;
    }


}
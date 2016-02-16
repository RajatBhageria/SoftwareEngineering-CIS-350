package edu.upenn.cis350.hwk2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.media.session.MediaControllerCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.logging.Level;

/**
 * Created by RajatBhageria on 2/13/16.
 */
public class GameView extends View {
    public GameView (Context c) {
        super(c);
    }
    public GameView(Context c, AttributeSet a) {
        super(c, a);
    }
    private Point[][] board;
    public void onDraw(Canvas canvas){
        int boardSize =  GameActivity.boardSize;
        Bitmap img = BitmapFactory.decodeResource(getResources(),
                R.drawable.dot);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int widthGap = width/(boardSize);
        int heightGap = height/(boardSize);
        int numberOfDotsX = 0;
        int numberOfDotsY = 0;
        for (int i = boardSize +100; i < width && numberOfDotsX<= boardSize; i+=widthGap){
            for (int j = boardSize +100; j < height && numberOfDotsY <= boardSize; j+=heightGap){
                canvas.drawBitmap(img, i, j, null);
                board = new Point[boardSize][boardSize];
                board[numberOfDotsX][numberOfDotsY] =new Point(i, j);
                numberOfDotsX++;
            }
            numberOfDotsY++;
            numberOfDotsX=0;
        }
        /*
        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setStrokeWidth(10);
        canvas.drawLine(40, 20, 60, 50, p);
        */
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        float x = e.getX();
        float y = e.getY();

        return true;
    }
}

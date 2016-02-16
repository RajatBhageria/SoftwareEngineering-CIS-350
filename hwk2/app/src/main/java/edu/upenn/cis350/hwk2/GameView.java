package edu.upenn.cis350.hwk2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.media.session.MediaControllerCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.LinkedList;
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
        p.setAntiAlias(true);
        p.setStrokeWidth(10);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeJoin(Paint.Join.ROUND);
        p.setStrokeCap(Paint.Cap.ROUND);
    }

    private Point[][] board;
    private ArrayList<Line> lines = new ArrayList<Line>();
    public void onDraw(Canvas canvas){
        int boardSize =  GameActivity.boardSize;
        board = new Point[boardSize][boardSize];
        Bitmap img = BitmapFactory.decodeResource(getResources(), R.drawable.dot);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int widthGap = width/(boardSize);
        int heightGap = height/(boardSize);
        int numberOfDotsX = 0;
        int numberOfDotsY = 0;
        for (int i = boardSize +100; i < width && numberOfDotsX<= boardSize; i+=widthGap){
            for (int j = boardSize +100; j < height && numberOfDotsY <= boardSize; j+=heightGap){
                canvas.drawBitmap(img, i, j, null);
                board[numberOfDotsX][numberOfDotsY] =new Point(i+10, j+10);
                //System.out.println(i + " , "+ j);
                numberOfDotsX++;
            }
            numberOfDotsY++;
            numberOfDotsX=0;
        }

        mCanvas = canvas;
        for (int i = 0; i < lines.size(); i++){
            Line line = lines.get(i);
            canvas.drawLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY(), p);

        }

    }
    private void soutBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.println(board[i][j]);
            }
        }

    }
    private Canvas mCanvas = null;
    private Paint p = new Paint();
    private Path path = new Path();

    private Point getCorrectPoint(float x, float y){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                float xCoord = board[i][j].getX();
                float yCoord = board[i][j].getY();
                if (Math.abs(x-xCoord) <=30 && Math.abs(y-yCoord) <=30){
                    return board[i][j];
                }
            }
        }
        return null;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        float x = event.getX();
        float y = event.getY();

        Line line = new Line();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (getCorrectPoint(x,y) != null){
                    Point correctStart = getCorrectPoint(x,y);
                    line.setStart(correctStart.getX(), correctStart.getY());
                    lines.add(line);
                }
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                if (lines.size() > 0){
                    line = lines.get(lines.size()-1);
                    line.setEnd(x, y);
                    mCanvas.drawLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY(), p);
                }
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                if (getCorrectPoint(x, y) != null){
                    Point correctEnd = getCorrectPoint(x,y);
                    line = lines.get(lines.size()-1);
                    line.setEnd(correctEnd.getX(), correctEnd.getY());
                    lines.add(line);
                }
                else{
                    lines.remove(lines.size()-1);
                }
                invalidate();
                break;
            default:
                return false;
        }
        return true;


        /*
       switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
               *//* for (int i = 0; i < board.length; i++){
                    for (int j = 0; j < board[i].length; j++){
                        if (board[i][j].isCorrectPoint(x,y)){
                            startingPoint = board[i][j];
                            mCanvas.drawLine(startingPoint.getX(), startingPoint.getY(), 60, 50, mPaint);

                        }
                    }
                }*//*
                invalidate();
                break;

        }*/
    }
}

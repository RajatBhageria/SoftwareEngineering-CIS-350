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
        redP.setStrokeWidth(10);
        redP.setStyle(Paint.Style.STROKE);
        redP.setStrokeJoin(Paint.Join.ROUND);
        redP.setStrokeCap(Paint.Cap.ROUND);
        redP.setColor(Color.rgb(255,0,0));

        blueP.setStrokeWidth(10);
        blueP.setStyle(Paint.Style.STROKE);
        blueP.setStrokeJoin(Paint.Join.ROUND);
        blueP.setStrokeCap(Paint.Cap.ROUND);
        blueP.setColor(Color.rgb(30,144,255));

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
                numberOfDotsX++;
            }
            numberOfDotsY++;
            numberOfDotsX=0;
        }

        mCanvas = canvas;
        for (int i = 0; i < lines.size(); i++){
            Line line = lines.get(i);
            if (line.isRed()){
                canvas.drawLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY(), redP);
            }
            else{
                canvas.drawLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY(), blueP);
            }
        }

    }
    private Canvas mCanvas = null;

    private Paint redP = new Paint();
    private Paint blueP = new Paint();

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
    private int counter = 0;

    private Line currentLine = new Line();
    @Override
    public boolean onTouchEvent(MotionEvent event){
        float x = event.getX();
        float y = event.getY();

        //Line line = new Line();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (getCorrectPoint(x,y) != null){
                    Point correctStart = getCorrectPoint(x,y);
                    //line.setStart(correctStart.getX(), correctStart.getY());
                    currentLine.setStart(correctStart.getX(), correctStart.getY());
                    if (counter % 2 == 0) currentLine.setToRed();
                    //lines.add(line);
                }
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                /*if (lines.size() > 0){
                    //line = lines.get(lines.size()-1);
                    if (!currentLine.isConnected()){
                        currentLine.setEnd(x, y);
                        if (currentLine.isRed()){
                            mCanvas.drawLine(currentLine.getStartX(), currentLine.getStartY(), currentLine.getEndX(), currentLine.getEndY(), redP);
                        } else{
                            mCanvas.drawLine(currentLine.getStartX(), currentLine.getStartY(), currentLine.getEndX(), currentLine.getEndY(), blueP);
                        }
                    }
                    else{
                        break;
                    }
                }*/
                if (!currentLine.isConnected()){
                    currentLine.setEnd(x, y);
                    if (currentLine.isRed()){
                        mCanvas.drawLine(currentLine.getStartX(), currentLine.getStartY(), currentLine.getEndX(), currentLine.getEndY(), redP);
                    } else{
                        mCanvas.drawLine(currentLine.getStartX(), currentLine.getStartY(), currentLine.getEndX(), currentLine.getEndY(), blueP);
                    }
                }
                else{
                    break;
                }
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                //line = lines.get(lines.size()-1);
               /* if (point != null && currentLine.lineIsHorizontalOrVertical()){
                    Point correctEnd = getCorrectPoint(x,y);
                    currentLine.setEnd(correctEnd.getX(), correctEnd.getY());
                    currentLine.setToConnected();
                    lines.add(currentLine);
                    counter++;
                }
                else{
                    lines.remove(lines.size() - 1);
                }*/
                Point correctEnd = getCorrectPoint(x, y);
                if (correctEnd != null){
                    currentLine.setEnd(correctEnd.getX(), correctEnd.getY());
                    currentLine.setToConnected();
                    if (currentLine.lineIsHorizontalOrVertical()) {
                        lines.add(currentLine);
                        counter++;
                    }
                }
                currentLine = new Line();

                invalidate();
                break;
            default:
                return false;
        }
        return true;

    }
}

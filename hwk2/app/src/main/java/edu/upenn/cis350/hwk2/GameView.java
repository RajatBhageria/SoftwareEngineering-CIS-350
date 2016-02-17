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
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.logging.Level;

/**
 * Created by RajatBhageria on 2/13/16.
 */
public class GameView extends View {
    public GameView (Context c) {
        super(c);
        mContext = c;

    }
    Line[][] verticalLines;
    Line[][] horizontalLines;
    public GameView(Context c, AttributeSet a) {
        super(c, a);
        redP.setStrokeWidth(10);
        redP.setStyle(Paint.Style.STROKE);
        redP.setStrokeJoin(Paint.Join.ROUND);
        redP.setStrokeCap(Paint.Cap.ROUND);
        redP.setColor(Color.rgb(255, 0, 0));

        blueP.setStrokeWidth(10);
        blueP.setStyle(Paint.Style.STROKE);
        blueP.setStrokeJoin(Paint.Join.ROUND);
        blueP.setStrokeCap(Paint.Cap.ROUND);
        blueP.setColor(Color.rgb(30, 144, 255));

        verticalLines = new Line[7][7];
        horizontalLines = new Line[7][7];

        for (int i = 0; i < verticalLines.length; i ++){
            for (int j = 0; j < verticalLines[0].length; j++){
                verticalLines[i][j] = null;
                horizontalLines[i][j] = null;
            }
        }
    }
    private Context mContext;
    private Point[][] board;
    private int boardS;
    private ArrayList<Line> lines = new ArrayList<Line>();

    public void onDraw(Canvas canvas){
        int boardSize =  GameActivity.boardSize;
        boardS = boardSize;
        board = new Point[boardSize][boardSize];
        Bitmap img = BitmapFactory.decodeResource(getResources(), R.drawable.dot);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int widthGap = width/(boardSize);
        int heightGap = height/(boardSize);
        int numberOfDotsX = 0;
        int numberOfDotsY = 0;
        for (int i = boardSize; i < width && numberOfDotsX<= boardSize; i+=widthGap){
            for (int j = boardSize; j < height && numberOfDotsY <= boardSize; j+=heightGap){
                canvas.drawBitmap(img, i, j, null);
                board[numberOfDotsX][numberOfDotsY] =new Point(i+10, j+10);
                board[numberOfDotsX][numberOfDotsY].setGridLocation(numberOfDotsX, numberOfDotsY);
                numberOfDotsX++;
            }
            numberOfDotsY++;
            numberOfDotsX=0;
        }

        mCanvas = canvas;
        for (int i = 0; i < lines.size(); i++){
            Line line = lines.get(i);
            if (line.isRed()){
                canvas.drawLine(line.getStartX(), line.getStartY(),
                        line.getEndX(), line.getEndY(), redP);
            }
            else{
                canvas.drawLine(line.getStartX(), line.getStartY(),
                        line.getEndX(), line.getEndY(), blueP);
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

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (getCorrectPoint(x,y) != null){
                    Point correctStart = getCorrectPoint(x,y);
                    System.out.println("begin: " + correctStart.getXGridLocation()+" : " +correctStart.getYGridLocation());
                    currentLine.setStart(correctStart.getX(), correctStart.getY());
                    currentLine.setStartPoint(getCorrectPoint(x,y));
                    if (counter % 2 == 0) currentLine.setToRed();
                }
                invalidate();
                break;

            case MotionEvent.ACTION_MOVE:
                if (!currentLine.isConnected()){
                    currentLine.setEnd(x, y);
                    if (currentLine.isRed()){
                        mCanvas.drawLine(currentLine.getStartX(), currentLine.getStartY(),
                                currentLine.getEndX(), currentLine.getEndY(), redP);
                    } else{
                        mCanvas.drawLine(currentLine.getStartX(), currentLine.getStartY(),
                                currentLine.getEndX(), currentLine.getEndY(), blueP);
                    }
                }
                else{
                    break;
                }
                invalidate();
                break;

            case MotionEvent.ACTION_UP:
                Point correctEnd = getCorrectPoint(x, y);
                System.out.println("end: " + correctEnd.getXGridLocation()+" : " +correctEnd.getYGridLocation());
                if (correctEnd != null){
                    currentLine.setEnd(correctEnd.getX(), correctEnd.getY());
                    currentLine.setEndPoint(correctEnd);
                    if (currentLine.lineIsHorizontalOrVertical()) {
                        for (int i = 0; i < lines.size(); i++){
                            if (lines.get(i).sameAs(currentLine)){
                                currentLine = new Line();
                                break;
                            }
                        }
                        lines.add(currentLine);
                        currentLine.setToConnected();
                        addLineToBox(currentLine);
                        testIfSquaresDone();
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

    private void addLineToBox(Line line){
        if (line.isHorizontal()){
            int yValue = Math.min(line.getStartPoint().getXGridLocation(),
                    line.getEndPoint().getXGridLocation());
            int xValue = line.getStartPoint().getYGridLocation();
            horizontalLines[xValue][yValue] = line;
            System.out.println("Horizontal: " + xValue + "," + yValue);


        }
        else if (line.isVertical()){
            int xValue = Math.min(line.getStartPoint().getYGridLocation(),
                    line.getEndPoint().getYGridLocation());
            int yValue = line.getStartPoint().getXGridLocation();
            verticalLines[xValue][yValue] = line;
            System.out.println("Vertical: " + xValue + "," + yValue);

        }
    }

    public boolean isSquareComplete(int x, int y) {
        return (horizontalLines[x][y]!= null && horizontalLines[x][y+1]!= null
                && verticalLines[x][y] != null && verticalLines[x+1][y]!= null );
    }

    private int numberOfComplete = 0;

    public void testIfSquaresDone() {
        int tempComplete = 0;
        for (int i = 0; i < horizontalLines.length; i++) {
            for (int j = 0; j < verticalLines.length; j++) {
                if (isSquareComplete(i,j)){
                    tempComplete++;
                }
            }
        }
        if (tempComplete> numberOfComplete) numberOfComplete = tempComplete;

        if (numberOfComplete == Math.pow(boardS-1,2)){
            Toast.makeText(mContext, "Just won the game! ", Toast.LENGTH_LONG);

        }
        System.out.println("Number complete: " + numberOfComplete);
    }


}

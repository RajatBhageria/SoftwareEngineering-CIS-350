package edu.upenn.cis350.hwk2;

/**
 * Created by RajatBhageria on 2/16/16.
 */
public class Point {
    private int mXCoord = 0;
    private int mYCoord = 0;
    public Point(int x, int y){
        mXCoord = x;
        mYCoord = y;
    }
    public int getX(){
        return mXCoord;
    }
    public int getY(){
        return mYCoord;
    }
}

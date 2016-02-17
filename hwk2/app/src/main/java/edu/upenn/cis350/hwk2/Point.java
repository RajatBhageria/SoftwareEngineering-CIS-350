package edu.upenn.cis350.hwk2;

/**
 * Created by RajatBhageria on 2/16/16.
 */
public class Point {
    private float mXCoord = 0;
    private float mYCoord = 0;
    public Point(float x, float y){
        mXCoord = x;
        mYCoord = y;
    }
    public float getX(){
        return mXCoord;
    }
    public float getY(){
        return mYCoord;
    }
    @Override
    public String toString(){
        return ("X Coord: " + mXCoord + ", Y Coord: " + mYCoord);
    }
}

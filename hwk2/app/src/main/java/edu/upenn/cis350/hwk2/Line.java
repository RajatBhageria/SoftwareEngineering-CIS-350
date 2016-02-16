package edu.upenn.cis350.hwk2;

/**
 * Created by RajatBhageria on 2/16/16.
 */
public class Line {
    public Line(){

    }
    public Line(float startX, float startY){
        mStartX = startX;
        mStartY = startY;
    }
    public void setStart(float startX, float startY){
        mStartX = startX;
        mStartY = startY;
    }
    public void setEnd(float endX, float endY){
        mEndX = endX;
        mEndY = endY;
    }

    public float getStartX(){
        return mStartX;
    }
    public Line getLine(float startX, float startY){
        if (mStartX == startX && mStartY == startY) return this;
        return new Line();
    }
    public float getStartY(){
        return mStartY;
    }
    public float getEndX(){
        return mEndX;
    }
    public float getEndY(){
        return mEndY;
    }

    private float mStartX, mStartY,mEndX, mEndY;

}

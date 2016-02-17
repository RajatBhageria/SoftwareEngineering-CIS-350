package edu.upenn.cis350.hwk2;

/**
 * Created by RajatBhageria on 2/16/16.
 */
public class Line {
    public Line(){

    }
    private boolean isRed = false;
    public boolean isRed(){
        return isRed;
    }
    public void setToRed(){
        isRed = true;
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

    public float getStartY(){
        return mStartY;
    }
    public float getEndX(){
        return mEndX;
    }
    public float getEndY(){
        return mEndY;
    }
    public void setToConnected(){
        isConnected = true;
    }
    public boolean isConnected(){
        return isConnected;
    }
    private Point startPoint, endPoint = null;
    public void setStartPoint(Point p){
        startPoint = p;
    }
    public void setEndPoint(Point p){
        endPoint = p;
    }
    public Point getStartPoint(){
        return startPoint;
    }
    public Point getEndPoint(){
        return endPoint;
    }
    public boolean lineIsHorizontalOrVertical(){
        return Math.abs(getStartX()-getEndX()) <= 10 ||
                Math.abs(getStartY()-getEndY()) <= 10;
    }

    public boolean isVertical(){
        return Math.abs(getStartX()-getEndX()) <= 10;
    }

    public boolean isHorizontal(){
        return Math.abs(getStartY()-getEndY()) <= 10;
    }

    public boolean lineIsRightSize(){
        return Math.abs(getStartX()-getEndX()) <= 10 ||
                Math.abs(getStartY()-getEndY()) <= 10;
    }
    private float mStartX, mStartY,mEndX, mEndY;
    private boolean isConnected = false;

    public boolean sameAs(Line line){
        if (line.getStartX() == getStartX() &&
                line.getEndX() == getEndX() &&
                line.getStartY() == getStartY() &&
                line.getEndY() == getEndY())
        {return true;}
        return false;
    }

}

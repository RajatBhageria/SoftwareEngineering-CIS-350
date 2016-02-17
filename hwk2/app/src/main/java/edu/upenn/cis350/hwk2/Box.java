package edu.upenn.cis350.hwk2;

/**
 * Created by RajatBhageria on 2/16/16.
 */
public class Box {
    public Box(){

    }
    public Line getLeftVert(){
        return leftVert;
    }
    public Line getRightVert(){
        return rightVert;
    }
    public Line getTop(){
        return top;
    }
    public Line getBottom(){
        return bottom;
    }

    public void setLeftVert(Line line){
        leftVert = line;
    }
    public void setRightVert(Line line){
        rightVert = line;
    }
    public void setTop(Line line){
        top = line;
    }
    public void setBottom(Line line){
        bottom = line;
    }
    public boolean containsSide(Line line){
        return leftVert.equals(line) ||
                rightVert.equals(line) ||
                top.equals(line) ||
                bottom.equals(line);
    }
    private Line leftVert, rightVert, top, bottom;
}

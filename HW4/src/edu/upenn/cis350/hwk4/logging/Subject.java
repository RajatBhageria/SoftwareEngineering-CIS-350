package edu.upenn.cis350.hwk4.logging;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RajatBhageria on 3/29/16.
 */
public class Subject {
    private List<Logger> observers = new ArrayList<Logger>();
    public void add(Logger observer){
        observers.add(observer);
    }
    public void notifyAllObservers(){
        for (Logger observer : observers) {
            observer.info(state);
        }
    }
    public void setState (String state){
        this.state = state;
        notifyAllObservers();
    }
    private String state;

}

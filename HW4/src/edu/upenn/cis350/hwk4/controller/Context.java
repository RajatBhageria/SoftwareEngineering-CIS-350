package edu.upenn.cis350.hwk4.controller;

import java.util.ArrayList;

/**
 * Created by RajatBhageria on 3/30/16.
 * This is used to implement the strategy design pattern
 */
public class Context {
    private Strategy strategy;
    public Context (Strategy strategy){
        this.strategy = strategy;
    }
    public ArrayList<String> executeStrategy(){
        return strategy.getAnswer();
    }
}

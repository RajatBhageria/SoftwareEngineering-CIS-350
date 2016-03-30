package edu.upenn.cis350.hwk4.controller;

/**
 * Created by RajatBhageria on 3/30/16.
 */
public class Context {
    private Strategy strategy;
    public Context (Strategy strategy){
        this.strategy = strategy;

    }
    public void executeStrategy(){
        strategy.getAnswer();
    }
}

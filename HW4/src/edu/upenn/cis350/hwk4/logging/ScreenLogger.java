package edu.upenn.cis350.hwk4.logging;

import java.util.logging.Logger;

/**
 * Created by RajatBhageria on 3/28/16.
 */
public class ScreenLogger {
    private static ScreenLogger screenLogger = null;

    private ScreenLogger(){

    }
    public static ScreenLogger getInstance(){
        if (screenLogger == null){
            screenLogger = new ScreenLogger();
        }
        return screenLogger;
    }
    public void println(String e){
        System.out.println(e);
    }
}

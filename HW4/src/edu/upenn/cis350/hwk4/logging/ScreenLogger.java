package edu.upenn.cis350.hwk4.logging;

import java.util.logging.Logger;

/**
 * Created by RajatBhageria on 3/28/16.
 */
public class ScreenLogger extends edu.upenn.cis350.hwk4.logging.Logger {
    private static ScreenLogger screenLogger = null;
    private ScreenLogger(){

    }

    public static ScreenLogger getInstance() {
        if (screenLogger == null) {
            screenLogger = new ScreenLogger();
        }
        return screenLogger;
    }

    @Override
    public void info(String e) {
        System.out.println(e);
    }

}

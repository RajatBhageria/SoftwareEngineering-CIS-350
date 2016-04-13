package edu.upenn.cis350.hwk4.logging;

import edu.upenn.cis350.hwk4.Main;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by RajatBhageria on 3/28/16.
 * This follows the singleton design pattern
 */
public class FileLogger extends edu.upenn.cis350.hwk4.logging.Logger {
    protected static FileLogger instance = null;
    private static String logFileName = "src/edu/upenn/cis350/hwk4/" + Main.logName;

    private FileLogger() {
        FileHandler fh;
        try {
            fh = new FileHandler(logFileName);
            log.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static FileLogger getInstance(){
        if (instance == null){
            instance = new FileLogger();
        }
        return instance;
    }
    protected final static Logger log = Logger.getLogger(Main.logName);

    @Override
    public void info(String msg) {
        log.info(msg);
    }



}

package edu.upenn.cis350.hwk4.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by RajatBhageria on 3/28/16.
 */
public class FileLogger {
    private static Logger instance;
    public static Logger getInstance(){
        return instance;
    }
    public static Logger setupLogger(String name){
        instance = Logger.getLogger(name);
        FileHandler fh;

        String fileName = "src/edu/upenn/cis350/hwk1/" + name;
        try {
            fh = new FileHandler(fileName);
            instance.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            //fh.close();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return instance;
    }
    public void log(){

    }


}

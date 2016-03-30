package edu.upenn.cis350.hwk4;

import edu.upenn.cis350.hwk4.controller.ReaderFactory;
import edu.upenn.cis350.hwk4.controller.fileTypeReader;
import edu.upenn.cis350.hwk4.logging.FileLogger;
import edu.upenn.cis350.hwk4.ui.MainMenu;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {

    //public JSONParser parser = new JSONParser();

    private static Logger logger;

    public static String typeOfFile ="";
    public static String fileName ="";
    public static String logName = "";

    public static void main(String[] args) {
	// write your code here

        if (args.length != 3) {
            System.out.println("Please enter 3 arguments: string whether the file is a JSON or TEXT file, " +
                    "the JSON/TEXT file, and log file");
            System.exit(0);
        }

        typeOfFile = (String) args[0];
        fileName = (String) args[1];
        logName = (String) args[2];
        //ArrayList<String> list = Main.Reader(fileName);

        fileTypeReader reader = ReaderFactory.getReader();
        reader.read();

        //Log.setupLogger(logName);
        FileLogger log = FileLogger.getInstance();
        log.info("wassup homies!!!");


        MainMenu.createMenu();
    }
}

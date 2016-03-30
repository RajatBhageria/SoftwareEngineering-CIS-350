package edu.upenn.cis350.hwk4;

import edu.upenn.cis350.hwk4.datamanagement.ReaderFactory;
import edu.upenn.cis350.hwk4.datamanagement.FileTypeReader;
import edu.upenn.cis350.hwk4.logging.FileLogger;
import edu.upenn.cis350.hwk4.logging.ScreenLogger;
import edu.upenn.cis350.hwk4.logging.Subject;
import edu.upenn.cis350.hwk4.ui.MainMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {

    //public JSONParser parser = new JSONParser();

    private static Logger logger;

    public static String typeOfFile ="";
    public static String fileName ="";
    public static String logName = "";

    public static Subject subject = new Subject();

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

        FileTypeReader reader = ReaderFactory.getReader();
        List<String> list = reader.read();


        FileLogger fileLogger= FileLogger.getInstance();
        ScreenLogger screenLogger = ScreenLogger.getInstance();
        subject.add(fileLogger);
        subject.add(screenLogger);

        subject.setState("YOOOO");

        MainMenu.createMenu();
        for (String e: list ){
            System.out.println(e);
        }
    }

}

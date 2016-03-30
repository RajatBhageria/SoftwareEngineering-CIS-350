package edu.upenn.cis350.hwk4;

import edu.upenn.cis350.hwk4.data.DataStorage;
import edu.upenn.cis350.hwk4.datamanagement.ReaderFactory;
import edu.upenn.cis350.hwk4.datamanagement.FileTypeReader;
import edu.upenn.cis350.hwk4.logging.FileLogger;
import edu.upenn.cis350.hwk4.logging.ScreenLogger;
import edu.upenn.cis350.hwk4.logging.Subject;
import edu.upenn.cis350.hwk4.ui.InputReader;
import java.util.ArrayList;

public class Main {

    public static String typeOfFile ="";
    public static String fileName ="";
    public static String logName = "";

    public static Subject subject;


    public static void main(String[] args) {
        typeOfFile = (String) args[0];
        fileName = (String) args[1];
        logName = (String) args[2];

        subject = new Subject();

        FileLogger fileLogger= FileLogger.getInstance();
        fileLogger.info("SUPPPP");
        ScreenLogger screenLogger = ScreenLogger.getInstance();
        subject.add(fileLogger);
        subject.add(screenLogger);

        if (args.length != 3) {
            subject.setState("Please enter 3 arguments: string whether the file is a JSON or TEXT file, " +
                    "the JSON/TEXT file, and log file");
            System.exit(0);
        }

        subject.setState("The inputs are: "+ typeOfFile + " " + fileName + " " + logName);

        FileTypeReader reader = ReaderFactory.getReader();
        ArrayList<String> list = reader.read();
        DataStorage data = new DataStorage(list);
        ArrayList<String[]> finalData = data.getData();

        InputReader input = new InputReader(finalData);
    }

}

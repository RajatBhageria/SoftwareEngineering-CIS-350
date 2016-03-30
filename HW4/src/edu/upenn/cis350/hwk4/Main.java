package edu.upenn.cis350.hwk4;

import edu.upenn.cis350.hwk4.controller.Context;
import edu.upenn.cis350.hwk4.controller.CoursesAboveQualityRating;
import edu.upenn.cis350.hwk4.controller.CoursesByInstructor;
import edu.upenn.cis350.hwk4.controller.LowestDifficultyRatio;
import edu.upenn.cis350.hwk4.data.DataStorage;
import edu.upenn.cis350.hwk4.datamanagement.ReaderFactory;
import edu.upenn.cis350.hwk4.datamanagement.FileTypeReader;
import edu.upenn.cis350.hwk4.logging.FileLogger;
import edu.upenn.cis350.hwk4.logging.ScreenLogger;
import edu.upenn.cis350.hwk4.logging.Subject;
import edu.upenn.cis350.hwk4.ui.InputReader;
import edu.upenn.cis350.hwk4.ui.MainMenu;
import java.util.ArrayList;

public class Main {

    public static String typeOfFile ="";
    public static String fileName ="";
    public static String logName = "";

    public static Subject subject = new Subject();

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Please enter 3 arguments: string whether the file is a JSON or TEXT file, " +
                    "the JSON/TEXT file, and log file");
            System.exit(0);
        }

        typeOfFile = (String) args[0];
        fileName = (String) args[1];
        logName = (String) args[2];

        FileTypeReader reader = ReaderFactory.getReader();
        ArrayList<String> list = reader.read();
        DataStorage data = new DataStorage(list);
        ArrayList<String[]> finalData = data.getData();

        FileLogger fileLogger= FileLogger.getInstance();
        ScreenLogger screenLogger = ScreenLogger.getInstance();
        subject.add(fileLogger);
        subject.add(screenLogger);

        InputReader input = new InputReader(finalData);
    }

}

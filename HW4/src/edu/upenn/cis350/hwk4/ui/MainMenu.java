package edu.upenn.cis350.hwk4.ui;

import edu.upenn.cis350.hwk4.logging.FileLogger;
import edu.upenn.cis350.hwk4.logging.ScreenLogger;

/**
 * Created by RajatBhageria on 3/28/16.
 */
public class MainMenu {
    public static void MainMenu(){

    }
    public static void createMenu(){
        String options = ("Here are your options:");
        String allOptions = ("Find all courses taught by a specified instructor (Press 4)\n" +
                "Find the top five courses with the lowest difficulty-to-quality ratio across all offering (Press 5)\n" +
                "Find all courses at or above a specified quality rating across all offerings (Press 6)\n" +
                "Quit the program (Press Q)");
        FileLogger fileLogger = FileLogger.getInstance();
        ScreenLogger screenLogger = ScreenLogger.getInstance();
        fileLogger.info(options);
        screenLogger.println(options);
        fileLogger.info(allOptions);
        screenLogger.println(allOptions);
    }
}

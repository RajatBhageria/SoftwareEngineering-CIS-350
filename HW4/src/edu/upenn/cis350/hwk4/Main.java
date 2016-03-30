package edu.upenn.cis350.hwk4;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Main {

    //public JSONParser parser = new JSONParser();

    private static Logger logger;

    public static void main(String[] args) {
	// write your code here

        if (args.length != 3) {
            System.out.println("Please enter 3 arguments: string whether the file is a JSON or TEXT file, " +
                    "the JSON/TEXT file, and log file");
            System.exit(0);
        }


        String typeOfFile = (String) args[0];
        String fileName = (String) args[1];
        String logName = (String) args[2];
        //ArrayList<String> list = Main.Reader(fileName);



        if (fileName.equalsIgnoreCase("TEXT")){

        } else if (fileName.equalsIgnoreCase("JSON")){

        }

        //logger = Main.Logger(logName);


    }
}

package edu.upenn.cis350.hwk1;

/**
 * Created by RajatBhageria on 1/24/16.
 */

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {

    public static void main (String[] args){

        if (args.length != 2) {
            System.out.println("Please enter 2 arguments: the course evaluations and the log file");
            //System.exit(0);
        }

        String fileName = (String) args[0];
        String logName = (String) args[1];
        ArrayList<String> list = Main.Reader(fileName);

        Parse parser = new Parse(list);

        Scanner scan = new Scanner (System.in);

        Main.MainMenu();
        String input = scan.nextLine();

        while (!input.equalsIgnoreCase("q")){
            if (input.equals("4")){
                System.out.println("Please enter the name of the instructor whose courses you want to see");
                String instructor = scan.nextLine();
                ArrayList<String> answer = parser.coursesByInstructor(instructor);
                String output = "";
                for (String e: answer){
                    output += e + ", ";
                }
                output = output.substring(0,output.length()-2);
                System.out.println(output);

            } else if (input.equals("5")){

            } else if (input.equals("6")){

            } else if (input.equalsIgnoreCase("Q")){
                System.exit(1);
            }
            MainMenu();
            input = scan.nextLine();
        }

        Main.Logger(logName);

    }

    public static ArrayList<String> Reader(String fileName){
        // The name of the file to open.
        fileName = "src/edu/upenn/cis350/hwk1/" + fileName;
        ArrayList<String> array = new ArrayList<String>();
        try {

            File file = new File(fileName);

            BufferedReader bufferReader;
            FileReader inputFile;
            if (file.canRead() && !file.isHidden()){
                //Create object of FileReader
                inputFile = new FileReader(file);
                //Instantiate the BufferedReader Class
                bufferReader= new BufferedReader(inputFile);

                //Variable to hold the one line data
                String line;

                // Read file line by line and print on the console
                while ((line = bufferReader.readLine()) != null)   {
                    array.add(line);
                }
                //Close the buffer reader
                bufferReader.close();

            }
        }catch(Exception e){
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }

        return array;
    }


    public static void Logger(String name){
        Logger logger = Logger.getLogger(name);
        FileHandler fh;

        String fileName = "src/edu/upenn/cis350/hwk1/" + name;
        try {

            fh = new FileHandler(fileName);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            logger.info("My first log");

        } catch (SecurityException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void MainMenu(){
        System.out.println("Here are your options:");
        System.out.println("Find all courses taught by a specified instructor (Press 4)\n" +
                "Find the top five courses with the lowest difficulty-to-quality ratio across all offering (Press 5)\n" +
                "Find all courses at or above a specified quality rating across all offerings (Press 6)\n" +
                "Quit the program (Press Q)");
    }

}

package edu.upenn.cis350.hwk1;

/**
 * Created by RajatBhageria on 1/24/16.
 */

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
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
        Logger logger = Main.Logger(logName);

        Scanner scan = new Scanner (System.in);

        Main.MainMenu();

        String input = scan.nextLine();
        logger.log(Level.INFO, input);

        while (!input.equalsIgnoreCase("q")){
            if (input.equals("4")){
                System.out.println("Please enter the name of the instructor whose courses you want to see");
                String instructor = scan.nextLine();
                ArrayList<String> answer = parser.coursesByInstructor(instructor);
                if (answer.isEmpty()){
                    //System.out.println("Sorry no instructor or courses found");
                    logger.log(Level.INFO,"Sorry no instructor or courses found");
                }
                else{
                    String output = "";
                    for (String e: answer){
                        output += e + ", ";
                    }
                    output = output.substring(0,output.length()-2);
                    logger.log(Level.INFO, output);
                    //System.out.println(output);
                }


            } else if (input.equals("5")){
                logger.log(Level.INFO,"The Five Easiest Courses (Organzied by Quality:Difficulty Ratio Are : ");
                TreeMap<Double, String> map = parser.lowestDifficultyRatio();
                for (int i =0; i < 5; i++){
                    Double rating =(Double) map.keySet().toArray()[i];
                    String courses = (String) map.values().toArray()[i];
                    //System.out.println(courses + ": " + rating);
                    logger.log(Level.INFO, courses + ": " + rating);
                }
            } else if (input.equals("6")){
                System.out.println("Please enter the minimum course quality you want");
                Double minQuality = (Double) Double.parseDouble(scan.nextLine());
                logger.log(Level.INFO,"The courses with a quality rating above " + minQuality + " are:");
                TreeMap<Double, String> qualityTree = parser.coursesAboveQualityRating();
                for (int i =0; i < qualityTree.values().size(); i++){
                    Double quality =(Double) qualityTree.keySet().toArray()[i];
                    String courses = (String) qualityTree.values().toArray()[i];
                    
                    if (quality >= minQuality ){
                        System.out.println(courses + ", " + quality);
                    }
                }

            } else if (input.equalsIgnoreCase("Q")){
                System.exit(1);
            }
            else{
                continue;
            }
            MainMenu();
            input = scan.nextLine();
            logger.log(Level.INFO, input);
        }
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


    public static Logger Logger(String name){
        logger = Logger.getLogger(name);
        FileHandler fh;

        String fileName = "src/edu/upenn/cis350/hwk1/" + name;
        try {
            fh = new FileHandler(fileName);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            fh.close();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return logger;
    }

    public static void MainMenu(){
        String options = ("Here are your options:");
        String allOptions = ("Find all courses taught by a specified instructor (Press 4)\n" +
                "Find the top five courses with the lowest difficulty-to-quality ratio across all offering (Press 5)\n" +
                "Find all courses at or above a specified quality rating across all offerings (Press 6)\n" +
                "Quit the program (Press Q)");
        //System.out.println(options);
        //System.out.println(allOptions);
        logger.log(Level.INFO, options);
        logger.log(Level.INFO, allOptions);
    }

    private static Logger logger;

}

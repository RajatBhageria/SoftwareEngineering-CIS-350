package edu.upenn.cis350.hwk4.ui;

import edu.upenn.cis350.hwk4.logging.FileLogger;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by RajatBhageria on 3/28/16.
 */
public class inputReader {
    private Logger logger = FileLogger.getInstance();
    public inputReader(String input){
        /*
        while (!input.equalsIgnoreCase("q")){
            if (input.equals("4")){
                logger.info("Please enter the name of the instructor whose courses you want to see");
                String instructor = scan.nextLine();
                logger.info("The instructor you searched for is: " + instructor);
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
                logger.info("Please enter the minimum course quality you want");
                Double minQuality = (Double) Double.parseDouble(scan.nextLine());
                logger.log(Level.INFO,"The courses with a quality rating above " + minQuality + " are:");
                TreeMap<Double, String> qualityTree = parser.coursesAboveQualityRating();
                for (int i =0; i < qualityTree.values().size(); i++){
                    Double quality =(Double) qualityTree.keySet().toArray()[i];
                    String courses = (String) qualityTree.values().toArray()[i];
                    //System.out.println(courses);
                    //System.out.println(quality);
                    if (quality >= minQuality){
                        //System.out.println(courses);
                        logger.log(Level.INFO,courses + ", " + quality);
                    }
                }

            } else if (input.equalsIgnoreCase("Q")){
                logger.info("program ended");
                System.exit(1);
            }
            else{
                logger.info("Please enter either '4,' '5,' '6,' or 'q'");
            }
            MainMenu main = new MainMenu();
            input = scan.nextLine();
            logger.log(Level.INFO, input);
        }
         */
    }

}

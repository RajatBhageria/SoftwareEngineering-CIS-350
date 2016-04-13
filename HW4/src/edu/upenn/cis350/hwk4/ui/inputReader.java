package edu.upenn.cis350.hwk4.ui;

import edu.upenn.cis350.hwk4.Main;
import edu.upenn.cis350.hwk4.controller.Context;
import edu.upenn.cis350.hwk4.controller.CoursesAboveQualityRating;
import edu.upenn.cis350.hwk4.controller.CoursesByInstructor;
import edu.upenn.cis350.hwk4.controller.LowestDifficultyRatio;
import edu.upenn.cis350.hwk4.logging.Subject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by RajatBhageria on 3/28/16.
 * This uses the strategy design pattern
 */
public class InputReader {
    private Subject subject = Main.subject;
    public InputReader(ArrayList<String[]> finalData){

        MainMenu.createMenu();

        Scanner scan = new Scanner (System.in);
        String input = scan.nextLine();
        subject.setState("You entered: " + input);
        while (!input.equalsIgnoreCase("q")){
            if (input.equals("4")){
                subject.setState("Please enter the name of the instructor whose courses you want to see");
                String instructor = scan.nextLine();
                subject.setState("The instructor you searched for is: " + instructor);
                Context context = new Context (new CoursesByInstructor(instructor,finalData));
                ArrayList<String> answer = context.executeStrategy();


                if (answer.isEmpty()){
                    subject.setState("Sorry no instructor or courses found");
                }
                else{
                    String output = "";
                    for (String e: answer){
                        output += e + ", ";
                    }
                    output = output.substring(0,output.length()-2);
                    subject.setState( output);
                }

            } else if (input.equals("5")){
                subject.setState("The Five Easiest Courses (Organzied by Quality:Difficulty Ratio Are : ");
                Context context2 = new Context (new LowestDifficultyRatio(finalData));
                ArrayList<String> array = context2.executeStrategy();
                for (String e: array){
                    subject.setState(e);
                }

            } else if (input.equals("6")){
                subject.setState("Please enter the minimum course quality you want");
                Double minQuality = 0.0;
                try{
                    minQuality= (Double) Double.parseDouble(scan.nextLine());
                    subject.setState("You entered: " + minQuality);
                } catch (Exception e){
                    subject.setState("Please enter a valid double");
                }
                subject.setState("The courses with a quality rating above " + minQuality + " are:");
                Context context3 = new Context (new CoursesAboveQualityRating(finalData, minQuality));
                ArrayList<String> array = context3.executeStrategy();
                for (String e: array){
                    subject.setState(e);
                }

            } else if (input.equalsIgnoreCase("Q")){
                subject.setState("Program Ended. Thanks for trying :) ");
                System.exit(1);
            }
            else{
                subject.setState("Please enter either '4,' '5,' '6,' or 'q'");
            }
            MainMenu.createMenu();
            input = scan.nextLine();
            subject.setState("Your input was: " + input);
        }
        subject.setState("Program Ended. Thanks for trying :) ");

    }

}

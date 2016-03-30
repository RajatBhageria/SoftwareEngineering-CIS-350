package edu.upenn.cis350.hwk4.controller;

import edu.upenn.cis350.hwk4.Main;
import edu.upenn.cis350.hwk4.logging.FileLogger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by RajatBhageria on 3/28/16.
 */
public class JSONReader implements fileTypeReader {
    private String fileName;
    public JSONReader(){
        fileName = "src/edu/upenn/cis350/hwk4/" + Main.fileName;
        ArrayList<String> array = new ArrayList<String>();
        //FileLogger.setupLogger(fileName);
        FileLogger logger = FileLogger.getInstance();
        try {

            File file = new File(fileName);

            BufferedReader bufferReader;
            FileReader inputFile;
            if (file.canRead() && !file.isHidden()){
                inputFile = new FileReader(file);
                bufferReader= new BufferedReader(inputFile);

                //Variable to hold the one line data
                String line;

                // Read file line by line and print on the console
                while ((line = bufferReader.readLine()) != null)   {
                    array.add(line.substring(line.indexOf("{"),line.indexOf("}")));
                }
                //Close the buffer reader
                bufferReader.close();
            }
            else if (!file.canRead()){
                logger.info("Sorry file cannot be read");
                System.exit(0);
            }
            else if (!file.isHidden()){
                logger.info("Sorry file is hidden");
                System.exit(0);
            }
        }catch(Exception e){
            logger.info("Error while reading file line by line:" + e.getMessage());
        }
    }
    public ArrayList<String> read(){

        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        try {
            obj = (JSONObject)parser.parse("hello");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //String product = (String)obj.get(“product”); // use key as argument Double price = (Double)obj.get(“price”);
        String course = (String) obj.get("course");
        String instructor = (String) obj.get("instructor");
        int enrollment = (Integer) obj.get("enrollment");
        double courseQuality = (Double) obj.get("courseQuality");
        double courseDifficulty = (Double ) obj.get("courseDifficulty");
        double instructorQuality = (Double) obj.get("instructorQuality");


        ArrayList<String> list = new ArrayList<String>();
        list.add(course);
        list.add(instructor);
        list.add(enrollment+"");
        list.add(courseQuality+"");
        list.add(courseDifficulty+"");
        list.add(instructorQuality+"");
        return list;
    }

}

package edu.upenn.cis350.hwk4.datamanagement;

import edu.upenn.cis350.hwk4.Main;
import edu.upenn.cis350.hwk4.logging.FileLogger;
import edu.upenn.cis350.hwk4.logging.Subject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by RajatBhageria on 3/28/16.
 */
public class JSONReader implements FileTypeReader {
    private String fileName;
    public JSONReader(){
        fileName = "src/edu/upenn/cis350/hwk4/" + Main.fileName;
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
                    jSONArrayList.add(line.substring(line.indexOf("{"),line.indexOf("}")+1));
                }
                //Close the buffer reader
                bufferReader.close();
            }
            else if (!file.canRead()){
                Main.subject.setState("Sorry file cannot be read");
                System.exit(0);
            }
            else if (!file.isHidden()){
                Main.subject.setState("Sorry file is hidden");
                System.exit(0);
            }
        }catch(Exception e){
            logger.info("Error while reading file line by line:" + e.getMessage());
        }
    }
    private ArrayList<String> jSONArrayList = new ArrayList<String>();
    private ArrayList<String> formattedList = new ArrayList<String>();

    public ArrayList<String> read(){

        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        for (int i=0; i < jSONArrayList.size();i++){
            try {
                obj = (JSONObject)parser.parse(jSONArrayList.get(i));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String course = (String) obj.get("course");
            String instructor = (String) obj.get("instructor");
            long enrollment = (Long) obj.get("enrollment");
            double courseQuality = (Double) obj.get("courseQuality");
            double courseDifficulty = (Double ) obj.get("courseDifficulty");
            double instructorQuality = (Double) obj.get("instructorQuality");

            String courseInfo = course + ", " + instructor + ", " + enrollment + ", " +
                    courseQuality + ", " + courseDifficulty + ", " + instructorQuality;
            formattedList.add(courseInfo);
        }

        return formattedList;
    }

}

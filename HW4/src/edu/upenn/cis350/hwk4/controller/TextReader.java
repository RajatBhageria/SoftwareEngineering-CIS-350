package edu.upenn.cis350.hwk4.controller;

import edu.upenn.cis350.hwk4.logging.FileLogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by RajatBhageria on 3/28/16.
 */
public class TextReader {
    private String fileName;
    public ArrayList<String> read(){
        // The name of the file to open.
        fileName = "src/edu/upenn/cis350/hwk1/" + fileName;
        ArrayList<String> array = new ArrayList<String>();
        FileLogger.setupLogger(fileName);
        Logger logger = FileLogger.getInstance();
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
                    array.add(line);
                }
                //Close the buffer reader
                bufferReader.close();
            }
            else if (!file.canRead()){
                logger.log(Level.ALL,"Sorry file cannot be read");
                System.exit(0);
            }
            else if (!file.isHidden()){
                logger.log(Level.ALL,"Sorry file is hidden");
                System.exit(0);
            }
        }catch(Exception e){
            logger.log(Level.FINE,"Error while reading file line by line:" + e.getMessage());
        }

        return array;
    }
}

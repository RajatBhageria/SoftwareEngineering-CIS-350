package edu.upenn.cis350.hwk4.datamanagement;

import edu.upenn.cis350.hwk4.Main;
import edu.upenn.cis350.hwk4.logging.FileLogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by RajatBhageria on 3/29/16.
 */
public class TextReader implements FileTypeReader {
    public  ArrayList<String> read() {
        // The name of the file to open.
        String fileName = "src/edu/upenn/cis350/hwk4/" + Main.fileName;
        //FileLogger.setupLogger(Main.logName);
        FileLogger logger = FileLogger.getInstance();
        ArrayList<String> array = new ArrayList<String>();
        try {

            File file = new File(fileName);

            BufferedReader bufferReader;
            FileReader inputFile;
            if (file.canRead() && !file.isHidden()) {
                inputFile = new FileReader(file);
                bufferReader = new BufferedReader(inputFile);

                //Variable to hold the one line data
                String line;

                // Read file line by line and print on the console
                while ((line = bufferReader.readLine()) != null) {
                    array.add(line);
                }
                //Close the buffer reader
                bufferReader.close();
            } else if (!file.canRead()) {
                logger.info("Sorry file cannot be read");
                System.exit(0);
            } else if (!file.isHidden()) {
                logger.info("Sorry file is hidden");
                System.exit(0);
            }
        } catch (Exception e) {
            logger.info("Error while reading file line by line:" + e.getMessage());
        }

        return array;
    }
}

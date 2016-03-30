package edu.upenn.cis350.hwk4.datamanagement;

import edu.upenn.cis350.hwk4.Main;

/**
 * Created by RajatBhageria on 3/29/16.
 */
public class ReaderFactory {

    public static FileTypeReader getReader(){
        if (Main.typeOfFile.equalsIgnoreCase("TEXT")) {
            return new TextReader();
        } else if (Main.typeOfFile.equalsIgnoreCase("JSON")){
            return new JSONReader();
        }
        return null;
    }

}

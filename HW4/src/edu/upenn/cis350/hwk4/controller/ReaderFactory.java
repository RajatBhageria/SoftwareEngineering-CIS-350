package edu.upenn.cis350.hwk4.controller;

import edu.upenn.cis350.hwk4.Main;

/**
 * Created by RajatBhageria on 3/29/16.
 */
public class ReaderFactory {

    public static fileTypeReader getReader(){
        if (Main.typeOfFile.equalsIgnoreCase("TEXT")) {
            return new TextReader();
        } else if (Main.typeOfFile.equalsIgnoreCase("JSON")){
            return new JSONReader();
        }
        return null;
    }

}

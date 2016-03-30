package edu.upenn.cis350.hwk4.data;

import java.util.ArrayList;

/**
 * Created by RajatBhageria on 3/30/16.
 */
public class DataStorage {
    private ArrayList<String[]> data;
    public DataStorage(ArrayList<String> array){
        data = new ArrayList<String[]>(array.size());
        for (int i = 0; i < array.size(); i++){
            String[] test = array.get(i).split(", ");
            data.add(test);
        }
    }
    public ArrayList<String[]> getData(){
        return data;
    }
}

package edu.upenn.cis350.hwk1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by RajatBhageria on 1/24/16.
 */
public class Parse {
    private ArrayList<String[]> data;
    public Parse(ArrayList<String> array){
        data = new ArrayList<String[]>(array.size());
        for (int i = 0; i < array.size(); i++){
            String[] test = array.get(i).split(", ");
            data.add(test);
            //System.out.println(test[0]);

        }
    }


    public ArrayList<String> coursesByInstructor(String instructor){
        instructor = instructor.toUpperCase();
        HashSet<String> set = new HashSet<String>();
        ArrayList<String> array = new ArrayList<String>();
        String wholeInstructor ="";
        for (int i = 0; i < data.size();i++){
            if (data.get(i)[1].contains(instructor)){
                set.add(data.get(i)[0]);
                wholeInstructor=data.get(i)[1];
            }
        }
        array.addAll(set);
        Collections.sort(array);
        array.add(0,wholeInstructor);
        return array;

        /*for (int i = 0; i < data.size(); i++){
            String teacher = data.get(i)[1];
            if (!map.containsKey(teacher)){
                map.put(teacher.toLowerCase(), new ArrayList<>());
                map.get(teacher).add(data.get(i)[0]);
            }
            else{
                map.get(teacher).add(data.get(i)[0]);
            }
        }
        if (map.containsKey(instructor.toLowerCase())){
            for (int j = 0; j < map.values().size();j++){
                String courseName = map.get(instructor.toLowerCase()).get(j);
                courses.add(courseName);
            }*/


    }
}

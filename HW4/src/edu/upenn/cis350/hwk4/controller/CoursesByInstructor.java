package edu.upenn.cis350.hwk4.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by RajatBhageria on 3/30/16.
 */
public class CoursesByInstructor implements Strategy{

    /*
        This is the method that returns the courses taught by a particular instructor
        @param The name of the instructor
        @return an an ArrayList with the instructor's name at index 0 and then all the courses taught by the instructor.
     */
    public CoursesByInstructor (String instructor, ArrayList<String[]> data){
        instructor = instructor.toUpperCase();
        HashSet<String> set = new HashSet<String>();
        array = new ArrayList<String>();
        String wholeInstructor ="";
        for (int i = 0; i < data.size();i++){
            if (data.get(i)[1].contains(instructor)){
                set.add(data.get(i)[0]);
                wholeInstructor=data.get(i)[1];
            }
        }
        //Convert set to array
        array.addAll(set);

        //Sort the array
        Collections.sort(array);

        //Add the instructor's name to top of array being returned
        array.add(0, wholeInstructor);
    }
    private ArrayList<String> array = null;

    public ArrayList<String> getAnswer(){
        return array;
    }

}

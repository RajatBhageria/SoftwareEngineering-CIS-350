package edu.upenn.cis350.hwk4.controller;

import edu.upenn.cis350.hwk4.Main;
import edu.upenn.cis350.hwk4.logging.Subject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.logging.Level;

/**
 * Created by RajatBhageria on 3/30/16.
 */
public class CoursesAboveQualityRating implements Strategy {

    private TreeGenerator treeGenerator = null;
    private double minQuality = 0;
    private Subject subject = new Subject();

    public CoursesAboveQualityRating(ArrayList<String[]> data, double pMinQuality) {
        minQuality = pMinQuality;
        TreeGenerator pTreeGenerator = new TreeGenerator(data);
        treeGenerator = pTreeGenerator;
        treeGenerator.treeGenerator();

    }


    /*
    A method that uses treeGenerator() to generate a tree mapping the total course quality to the course name
    @return Returns a treeMap mapping course quality to course name for all the courses
 */
    public ArrayList<String>  getAnswer(){
        HashSet<String> set = new HashSet<String>();

        TreeMap<Double, String> qualityTree = treeGenerator.getQualityTree();
        for (int i =0; i < qualityTree.values().size(); i++){
            Double quality =(Double) qualityTree.keySet().toArray()[i];
            String courses = (String) qualityTree.values().toArray()[i];
            if (quality >= minQuality){
                set.add(quality + " : " + courses);
            }
        }
        //Convert set to array
        array.addAll(set);

        //Sort the array
        Collections.sort(array);

        /*for (int i = 0; i < array.size();i++){
            String quality = array.get(i).substring(0,array.indexOf(":")+1);
            String course = array.get(i).substring(array.indexOf(":"), array.get(i).length());
            array.set(i,course + ": " + course);
        }
*/
        return array;
    }
    private ArrayList<String> array = new ArrayList<String>();

}

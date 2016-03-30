package edu.upenn.cis350.hwk4.controller;

import edu.upenn.cis350.hwk4.Main;
import edu.upenn.cis350.hwk4.logging.Subject;

import java.util.ArrayList;
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
        TreeMap<Double, String> qualityTree = treeGenerator.getQualityTree();
        for (int i =0; i < qualityTree.values().size(); i++){
            Double quality =(Double) qualityTree.keySet().toArray()[i];
            String courses = (String) qualityTree.values().toArray()[i];
            if (quality >= minQuality){
                array.add(courses + ": " + quality);
                //Main.subject.setState(courses + ": " + quality);
            }
        }
        return array;
    }
    private ArrayList<String> array = new ArrayList<String>();

}

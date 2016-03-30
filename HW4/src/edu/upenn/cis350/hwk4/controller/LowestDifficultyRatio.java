package edu.upenn.cis350.hwk4.controller;

import edu.upenn.cis350.hwk4.Main;
import edu.upenn.cis350.hwk4.logging.Subject;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by RajatBhageria on 3/30/16.
 */
public class LowestDifficultyRatio implements Strategy{

    private TreeGenerator treeGenerator = null;
    private Subject subject = Main.subject;

    public LowestDifficultyRatio(ArrayList<String[]> data) {
        TreeGenerator pTreeGenerator = new TreeGenerator(data);
        treeGenerator = pTreeGenerator;
    }

    /*
        A method that uses treeGenerator() to generate a tree mapping the course difficulty/quality ratio to  name
        @return Returns a treeMap mapping mapping the course difficulty/quality ratio to course name
    */
    public ArrayList<String> getAnswer(){
        treeGenerator.treeGenerator();
        TreeMap<Double, String> ratioTree = treeGenerator.getRatioTree();
        for (int i =0; i < 5; i++){
            Double rating =(Double) ratioTree.keySet().toArray()[i];
            String courses = (String) ratioTree.values().toArray()[i];
            //subject.setState(courses + ": " + rating);
            array.add(courses + ": " + rating);
        }
        return array;

    }
    private  ArrayList<String> array = new ArrayList<String>();


}

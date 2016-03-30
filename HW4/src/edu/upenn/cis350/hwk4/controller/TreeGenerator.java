package edu.upenn.cis350.hwk4.controller;

/**
 * Created by RajatBhageria on 3/28/16.
 */

import java.util.*;

/**
 * Created by RajatBhageria on 1/24/16.
 */
public class TreeGenerator {

    public TreeGenerator(ArrayList<String[]> pData)
    {
        data = pData;
    }

    /*
        Helps generate the editedCourseData tree. This tree maps the course name to an array with the course data
        The array contains at index 0 the number of students in the course, at index 1 the total courseDifficulty, and
        at index 2 the total course quality.
     */
    private void treeGeneratorHelper() {

        for (int i = 0; i < data.size(); i++) {
            String[] tempCourseData = data.get(i);
            String tempCourse = tempCourseData[0];
            int tempNumberOfStudents = Integer.parseInt(tempCourseData[2]);
            double tempCourseDifficulty = Double.parseDouble(tempCourseData[4]);
            double tempCourseQuality = Double.parseDouble(tempCourseData[3]);

            if (!editedCourseData.containsKey(tempCourse)) {
                editedCourseData.put(tempCourse, new Double[]{0.0, 0.0, 0.0, 0.0});
            }
            editedCourseData.get(tempCourse)[0] += tempNumberOfStudents;
            editedCourseData.get(tempCourse)[1] += tempNumberOfStudents * tempCourseDifficulty;
            editedCourseData.get(tempCourse)[2] += tempNumberOfStudents * tempCourseQuality;

        }
    }

    /*
        This method generates the ratioTree and qualityTree using the editedCourseData. The former two trees
        map the course ratio or the course quality to the course name.
     */
    public void treeGenerator() {
        treeGeneratorHelper();
        for (int i = 0; i < editedCourseData.size(); i++) {
            Double ratio = 0.0;
            String courseName = (String) editedCourseData.keySet().toArray()[i];
            Double numberOfStudents = (Double) editedCourseData.get(courseName)[0];
            Double courseDifficulty = (Double) editedCourseData.get(courseName)[1];
            Double courseQuality = (Double) editedCourseData.get(courseName)[2];
            ratio = courseDifficulty / courseQuality;
            ratioTree.put(ratio, courseName);
            Double qualityRatio = courseQuality / numberOfStudents;
            qualityTree.put(qualityRatio, courseName);
        }
    }

    private ArrayList<String[]> data = null;
    private TreeMap<String, Double[]> editedCourseData = new TreeMap<String, Double[]>();
    private TreeMap<Double, String> ratioTree = new TreeMap<Double, String>();
    private TreeMap<Double, String> qualityTree = new TreeMap<Double, String>();

    public TreeMap<Double, String> getRatioTree(){
        treeGenerator();
        return ratioTree;
    }


    public TreeMap<Double, String> getQualityTree(){
        treeGenerator();
        return qualityTree;
    }

}
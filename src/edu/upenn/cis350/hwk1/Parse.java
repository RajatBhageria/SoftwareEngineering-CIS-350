package edu.upenn.cis350.hwk1;

import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.Level;

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
        //Convert set to array
        array.addAll(set);

        //Sort the array
        Collections.sort(array);

        //Add the instructor's name to top of array being returned
        array.add(0, wholeInstructor);
        return array;

    }


 /*   private void treeGenerator(){
        String[] courseData = data.get(0);
        String course = courseData[0];
        String courseShortened = course.substring(0,course.indexOf("-",6));
        int totalNumberOfStudents=Integer.parseInt(courseData[2]);
        double courseDifficulty=Double.parseDouble(courseData[4]);
        double courseQuality=Double.parseDouble(courseData[3]);
        double totalDifficulty =courseDifficulty*totalNumberOfStudents;
        double totalQuality =courseQuality *totalNumberOfStudents;
        double ratio = 0;
        for (int i = 1; i < data.size(); i++){
            String[] tempCourseData = data.get(i);
            String tempCourse=tempCourseData[0];
            String tempCourseShortened = tempCourse.substring(0,tempCourse.indexOf("-",6));
            int tempNumberOfStudents=Integer.parseInt(tempCourseData[2]);
            double tempCourseDifficulty=Double.parseDouble(tempCourseData[4]);
            double tempCourseQuality=Double.parseDouble(tempCourseData[3]);
            double tempTotalCourseDifficulty = tempCourseDifficulty *tempNumberOfStudents;
            double tempTotalCourseQuality = tempCourseQuality *tempNumberOfStudents;

            if (course.equals(tempCourse)){
                totalDifficulty += tempTotalCourseDifficulty;
                totalQuality +=tempTotalCourseQuality;
                totalNumberOfStudents+=tempNumberOfStudents;

            } else if (!course.equals(tempCourse) && !courseShortened.equals(tempCourseShortened)){
                ratio = totalDifficulty/totalQuality;
                ratioTree.put(ratio, course);
                qualityTree.put(totalQuality/totalNumberOfStudents,course);
                course = tempCourse;
                totalDifficulty = tempTotalCourseDifficulty;
                totalQuality =tempTotalCourseQuality;
                totalNumberOfStudents = tempNumberOfStudents;
            }

        }

    }*/



/*    private void treeGeneratorHelper(int initial){
        String[] courseData = data.get(initial);
        if (data.get(initial) == null) return;
        else {
            String course = courseData[0];
            //String courseShortened = course.substring(0,course.indexOf("-",6));
            int totalNumberOfStudents=Integer.parseInt(courseData[2]);
            double courseDifficulty=Double.parseDouble(courseData[4]);
            double courseQuality=Double.parseDouble(courseData[3]);
            double totalDifficulty =courseDifficulty*totalNumberOfStudents;
            double totalQuality =courseQuality *totalNumberOfStudents;
            data.set(initial,null);
            double ratio = 0;
            for (int i = 1; i < data.size(); i++) {
                if (data.get(i) == null) break;
                String[] tempCourseData = data.get(i);
                String tempCourse = tempCourseData[0];
                //String tempCourseShortened = tempCourse.substring(0, tempCourse.indexOf("-", 6));
                int tempNumberOfStudents = Integer.parseInt(tempCourseData[2]);
                double tempCourseDifficulty = Double.parseDouble(tempCourseData[4]);
                double tempCourseQuality = Double.parseDouble(tempCourseData[3]);
                double tempTotalCourseDifficulty = tempCourseDifficulty * tempNumberOfStudents;
                double tempTotalCourseQuality = tempCourseQuality * tempNumberOfStudents;
                if (course.equals(tempCourse)) {
                    totalDifficulty += tempTotalCourseDifficulty;
                    totalQuality += tempTotalCourseQuality;
                    totalNumberOfStudents += tempNumberOfStudents;
                    data.set(i,null);
                }
            }
            ratio = totalDifficulty/totalQuality;
            ratioTree.put(ratio, course);
            qualityTree.put(totalQuality/totalNumberOfStudents,course);
        }


    }

    private void treeGenerator(){
       for (int i = 0; i < data.size();i++){
           treeGeneratorHelper(i);
       }
    }*/


    private void treeGeneratorHelper(){

        for (int i = 0; i < data.size(); i++){
            String[] tempCourseData = data.get(i);
            String tempCourse=tempCourseData[0];
            int tempNumberOfStudents=Integer.parseInt(tempCourseData[2]);
            double tempCourseDifficulty=Double.parseDouble(tempCourseData[4]);
            double tempCourseQuality=Double.parseDouble(tempCourseData[3]);

            if (!editedCourseData.containsKey(tempCourse)){
                editedCourseData.put(tempCourse, new Double[] {0.0,0.0,0.0,0.0});
            }
            editedCourseData.get(tempCourse)[0] += tempNumberOfStudents;
            editedCourseData.get(tempCourse)[1] += tempNumberOfStudents*tempCourseDifficulty;
            editedCourseData.get(tempCourse)[2] += tempNumberOfStudents*tempCourseQuality;

        }
    }
    public void treeGenerator(){
        treeGeneratorHelper();
        for (int i = 0; i < editedCourseData.size(); i++) {
            Double ratio=0.0;
            String courseName = (String) editedCourseData.keySet().toArray()[i];
            Double numberOfStudents = (Double) editedCourseData.get(courseName)[0];
            Double courseDifficulty = (Double)  editedCourseData.get(courseName)[1];
            Double courseQuality = (Double)  editedCourseData.get(courseName)[2];
            ratio = courseDifficulty/courseQuality;
            ratioTree.put(ratio, courseName);
            Double qualityRatio = courseQuality/numberOfStudents;
            qualityTree.put(qualityRatio,courseName);
        }
    }


    private TreeMap<String, Double[]> editedCourseData = new TreeMap<String, Double[]>();;
    private TreeMap<Double, String> ratioTree = new TreeMap<Double, String>();;
    private TreeMap<Double, String> qualityTree = new TreeMap<Double, String>();;

    public TreeMap<Double,String> coursesAboveQualityRating(){
        treeGenerator();
        return qualityTree;
    }
    public TreeMap<Double, String> lowestDifficultyRatio(){
        treeGenerator();
        return ratioTree;
    }


}

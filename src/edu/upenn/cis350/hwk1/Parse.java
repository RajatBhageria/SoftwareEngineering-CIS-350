package edu.upenn.cis350.hwk1;

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
        array.add(0,wholeInstructor);
        return array;

    }

    public TreeMap<Double, String> lowestDifficultyRatio(){
        treeGenerator();
        return ratioTree;
    }

    private void treeGenerator(){
        String[] courseData = data.get(0);
        String course = courseData[0];
        int totalNumberOfStudents=Integer.parseInt(courseData[2]);
        double courseDifficulty=Double.parseDouble(courseData[4]);
        double courseQuality=Double.parseDouble(courseData[3]);
        double totalDifficulty =courseDifficulty*totalNumberOfStudents;
        double totalQuality =courseQuality *totalNumberOfStudents;
        double ratio = 0;
        for (int i = 1; i < data.size(); i++){
            String[] tempCourseData = data.get(i);
            String tempCourse=tempCourseData[0];
            int tempNumberOfStudents=Integer.parseInt(tempCourseData[2]);
            double tempCourseDifficulty=Double.parseDouble(tempCourseData[4]);
            double tempCourseQuality=Double.parseDouble(tempCourseData[3]);
            double tempTotalCourseDifficulty = tempCourseDifficulty *tempNumberOfStudents;
            double tempTotalCourseQuality = tempCourseQuality *tempNumberOfStudents;

            if (course.equals(tempCourse)){
                totalDifficulty += tempTotalCourseDifficulty;
                totalQuality +=tempTotalCourseQuality;
                totalNumberOfStudents+=tempNumberOfStudents;

            } else if (!course.equals(tempCourse)){
                ratio = totalDifficulty/totalQuality;
                ratioTree.put(ratio, course);
                qualityTree.put(totalQuality/totalNumberOfStudents,course);
                course = tempCourse;
                totalDifficulty = tempTotalCourseDifficulty;
                totalQuality =tempTotalCourseQuality;
                totalNumberOfStudents = tempNumberOfStudents;
            }

        }

    }

    private TreeMap<Double, String> ratioTree = new TreeMap<Double, String>();;
    private TreeMap<Double, String> qualityTree = new TreeMap<Double, String>();;

    public TreeMap<Double,String> coursesAboveQualityRating(){
        treeGenerator();
        return qualityTree;
    }

}

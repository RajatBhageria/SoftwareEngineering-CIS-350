package edu.upenn.cis350.hwk4.data;

/**
 * Created by RajatBhageria on 3/28/16.
 */

import java.util.*;

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

    /*
        This is the method that returns the courses taught by a particular instructor
        @param The name of the instructor
        @return an an ArrayList with the instructor's name at index 0 and then all the courses taught by the instructor.
     */
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


    /*
        Helps generate the editedCourseData tree. This tree maps the course name to an array with the course data
        The array contains at index 0 the number of students in the course, at index 1 the total courseDifficulty, and
        at index 2 the total course quality.
     */
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
    /*
        This method generates the ratioTree and qualityTree using the editedCourseData. The former two trees
        map the course ratio or the course quality to the course name.
     */
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

    /*
        A method that uses treeGenerator() to generate a tree mapping the total course quality to the course name
        @return Returns a treeMap mapping course quality to course name for all the courses
     */
    public TreeMap<Double,String> coursesAboveQualityRating(){
        treeGenerator();
        return qualityTree;
    }

    /*
        A method that uses treeGenerator() to generate a tree mapping the course difficulty/quality ratio to  name
        @return Returns a treeMap mapping mapping the course difficulty/quality ratio to course name
    */
    public TreeMap<Double, String> lowestDifficultyRatio(){
        treeGenerator();
        return ratioTree;
    }
}

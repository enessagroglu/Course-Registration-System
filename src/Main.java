
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception
    {

        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader("C:\\Users\\omerc\\IdeaProjects\\test24l2\\src\\courses.json"));
        int StudentSemester=1;
        // typecasting obj to JSONObject
        JSONObject course = (JSONObject) obj; //all courses.
        JSONArray jsonArray = (JSONArray) course.get("courses"); // courses.
        for (Object o : jsonArray) {
            JSONObject item = (JSONObject) o; // only one course.
            String CourseName = (String) item.get("CourseName"); // get courseName
            String CourseCode = (String) item.get("CourseCode"); // get CourseCode
            Long Credit = (Long) item.get("Credit"); // get Credit
            Object PrerequisiteCourseCodes = item.get("PrerequisiteCourseCodes"); // get PrerequisiteCourseCodes
            Long courseSessions=(Long) item.get("courseSessions");
            Long requiredCredits = (Long) item.get("requiredCredits"); // get requiredCredits
            Long courseSemester = (Long) item.get("courseSemester"); // get courseSemester
            String courseType = (String) item.get("courseType"); // get courseType
            Long courseCurrentStudentNumber = (Long) item.get("courseCurrentStudentNumber"); //courseCurrentStudentNumber

            List<String> CourseArray = new ArrayList<String>();
            CourseArray.add(CourseName);
            CourseArray.add(CourseCode);
            CourseArray.add(Credit.toString());
            CourseArray.add(PrerequisiteCourseCodes.toString());
            CourseArray.add(requiredCredits.toString());
            CourseArray.add(courseSemester.toString());
            CourseArray.add(courseType);
            CourseArray.add(courseCurrentStudentNumber.toString());
            // PRINT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            if (courseSemester == StudentSemester) {
                System.out.println(CourseArray);
            }
        }
    }
}
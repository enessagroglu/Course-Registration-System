import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Course {
    public static ArrayList<String> allCourses;
    public static ArrayList<String> teAllCourses;
    public static ArrayList<String> fteCourses;
    public static ArrayList<String> nteCourses;
    private String courseName;
    //private CourseCode courseCode;
    private int credit;
    //private ArrayList<CourseCode> preRequisiteCourses;
    //private ArrayList<CourseSession> courseSessions;
    private int requiredCredits;
    //private Semester courseSemester;
    //private CourseType courseType;
    private static int courseCurrentStudentNumber;
    static List<String> CourseArray = new ArrayList<String>();
    public static Object test() throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader("src\\courses.json"));
        return obj;
    }
    static Object obj;

    static {
        try {
            obj = test();
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    static JSONObject course = (JSONObject) obj; //all courses.
    static JSONArray jsonArray = (JSONArray) course.get("courses"); // courses.


    // only one course.



    public static String getCourseName(JSONObject Item){return (String) Item.get("CourseName");}

    // add to CourseCode class. Dont here. Method must be type of class. Change it.
    public static String getCourseCode(JSONObject Item){return (String) Item.get("CourseCode");}

    public static long getCredit(JSONObject Item){return (long) Item.get("Credit");}

    // change it later. it is not object, array list.
    public static Object getPreRequisiteCourses(JSONObject Item){return Item.get("PrerequisiteCourseCodes");}

    public static long getRequiredCredits(JSONObject Item){return (long) Item.get("requiredCredits");}

    //Semester class must be type. Change it later.
    public static long getCourseSemester(JSONObject Item){return (long) Item.get("courseSemester");}

    //Semester class must be type. Change it later.
    public static String getCourseType(JSONObject Item) {return (String) Item.get("courseType");}

    //ArrayList<CourseSession> must be type. Change it later.
    public static long getCourseSessions(JSONObject Item) {return (long) Item.get("courseSessions");}

    //change it later.
    public boolean checkQouta(){
        return true;
    }
    public static void main(String[] args) {
        Student a = new Student();
        Random ran = new Random();
        int x = ran.nextInt(8) + 2015;
        ArrayList<String> StudentInfo=a.Student(x+"");
        System.out.println(StudentInfo);
        for (Object o : jsonArray) {
            List<String> courseArray = new ArrayList<String>(); //again and again reset courseArray
            JSONObject Item = (JSONObject) o; // item is object right? yeeees.
            long studentSemester = Long.parseLong(StudentInfo.get(2));
            if (studentSemester == getCourseSemester(Item)) { // if semester equals course semester in json file append array.
                courseArray.add(getCourseName(Item));
                courseArray.add(getCourseCode(Item));
                courseArray.add(String.valueOf(getCredit(Item)));
                courseArray.add(String.valueOf(getPreRequisiteCourses(Item)));
                courseArray.add(String.valueOf(getCourseSessions(Item)));
                courseArray.add(String.valueOf(getRequiredCredits(Item)));
                courseArray.add(String.valueOf(getCourseSemester(Item)));
                courseArray.add(String.valueOf(getCourseType(Item)));
                courseArray.add(String.valueOf(courseCurrentStudentNumber));
                System.out.println(courseArray);
            }
        }
    }
}

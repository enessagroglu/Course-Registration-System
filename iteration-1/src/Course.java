import java.util.ArrayList;

public class Course{

    private String courseName;
    private CourseCode courseCode;
    private int credit;
    private ArrayList<CourseCode> prequisiteCourses;
    private ArrayList<CourseSession> courseSessions;
    private int requiredCredits;
    private Semester courseSemester;
    private CourseType courseType;
    private int courseCurrentStudentNumber;

    public Course(String courseName, CourseCode courseCode, int credit, ArrayList<CourseCode> prequisiteCourses,
                  ArrayList<CourseSession> courseSessions, int requiredCredits, Semester courseSemester,
                  CourseType courseType, int courseCurrentStudentNumber) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credit = credit;
        this.prequisiteCourses = prequisiteCourses;
        this.courseSessions = courseSessions;
        this.requiredCredits = requiredCredits;
        this.courseSemester = courseSemester;
        this.courseType = courseType;
        this.courseCurrentStudentNumber = courseCurrentStudentNumber;
    }


    public int getRequiredCredits() {
        return requiredCredits;
    }
    public void setRequiredCredits(int requiredCredits) {
        this.requiredCredits = requiredCredits;
    }
    public Semester getCourseSemester() {
        return courseSemester;
    }
    public void setCourseSemester(Semester courseSemester) {
        this.courseSemester = courseSemester;
    }
    public CourseType getCourseType() {
        return courseType;
    }
    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }
    public int getCourseCurrentStudentNumber() {
        return courseCurrentStudentNumber;
    }
    public void setCourseCurrentStudentNumber(int courseCurrentStudentNumber) {
        this.courseCurrentStudentNumber = courseCurrentStudentNumber;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public int getCredit() {
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }
    public CourseCode getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(CourseCode courseCode) {
        this.courseCode = courseCode;
    }
    public ArrayList<CourseCode> getPrequisiteCourses() {
        return prequisiteCourses;
    }
    public void setPrequisiteCourses(ArrayList<CourseCode> prequisiteCourses) {
        this.prequisiteCourses = prequisiteCourses;
    }
    public ArrayList<CourseSession> getCourseSessions() {
        return courseSessions;
    }
    public void setCourseSessions(ArrayList<CourseSession> courseSessions) {
        this.courseSessions = courseSessions;
    }

    public CourseSession createSession(Course course,String startHour1, String startHour2, int courseQuota){

        int lastIndex = course.courseSessions.size() - 1;
        int sessionID = (course.courseSessions.get(lastIndex).getSessionID())+1;

        // Create an ArrayList of strings to hold the start hours for the session
        ArrayList<String> startHours = new ArrayList<>();
        startHours.add(startHour1);
        startHours.add(startHour2);

        // Create an instance of the CourseSession class
        CourseSession session = new CourseSession(startHours,sessionID,courseQuota,0);


        course.courseSessions.add(session);
        return session;

    }
}
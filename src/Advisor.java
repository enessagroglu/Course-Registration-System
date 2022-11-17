import java.util.ArrayList;

public class Advisor extends Person {

    private  String advisorID;

    public Advisor(String advisorID) {
        this.advisorID = advisorID;
    }

   /* @Override
    String getFullName() {
        return null;
    }*/

    @Override
    String getEmail() {
        return null;
    }

    @Override
    String getPassword() {
        return null;
    }

    @Override
    Boolean login(String userId, String password) {
        return null;
    }

    public String getAdvisorID() {
        return advisorID;
    }

    public void setAdvisorID(String advisorID) {
        this.advisorID = advisorID;
    }

    public Boolean approveCourseList(ArrayList<Course> selectedCourses, ArrayList<CourseSession> selectedSessions, Student student){
        return null;
    }

    public Boolean checkCourseQuota(CourseSession selectedSession, Student student, Course course){
        return null;
    }

    public Boolean checkCollidinCourses(Course course, CourseSession selectedSession, ArrayList<Course> selectedCourses){
        return null;
    }

    public Boolean checkPreQuisite(Course course, Student student){
        return null;
    }

    public Boolean checkTotalCredits(Course course, Student student){
        return null;
    }

    public void checkTELimitation(Student student, ArrayList<Course> courseList){

    }

    public void checkFTELimitation(Student student, ArrayList<Course> courseList){

    }

}
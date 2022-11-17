import java.util.ArrayList;

public class CourseSession {
    private ArrayList<String> startHour = new ArrayList<String>();
    private int sessionId;
    private int courseQouta;
    private int courseCurrentStudentNumber;

    public CourseSession(ArrayList<String> startHour, int sessionId, int courseQouta, int courseCurrentStudentNumber) {
        this.startHour = startHour;
        this.sessionId = sessionId;
        this.courseQouta = courseQouta;
        this.courseCurrentStudentNumber = courseCurrentStudentNumber;
    }

    public int getCourseCurrentStudentNumber() {
        return courseCurrentStudentNumber;
    }

    public void setCourseCurrentStudentNumber(int courseCurrentStudentNumber) {
        this.courseCurrentStudentNumber = courseCurrentStudentNumber;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public ArrayList<String> getStartHour() {
        return startHour;
    }

    public void setStartHour(ArrayList<String> startHour) {
        this.startHour = startHour;
    }

    public void incrementEnrolledStudentAmount(){
        this.courseCurrentStudentNumber += 1;
    }


}
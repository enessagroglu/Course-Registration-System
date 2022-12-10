import java.util.ArrayList;

public class CourseSession{
    // Attributes
    private ArrayList<String> startHour;
    private int sessionID;
    private int courseQuota;
    private int sessionCurrentStudentNumber;

    // Constructor
    public CourseSession(ArrayList<String> startHour, int sessionID, int courseQuota, int sessionCurrentStudentNumber) {
        this.startHour = startHour;
        this.sessionID = sessionID;
        this.courseQuota = courseQuota;
        this.sessionCurrentStudentNumber = sessionCurrentStudentNumber;
    }

    // Getter and setter methods
    public ArrayList<String> getStartHour() {
        return this.startHour;
    }

    public void setStartHour(ArrayList<String> startHour) {
        this.startHour = startHour;
    }

    public int getSessionID() {
        return this.sessionID;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

    public int getCourseQuota() {
        return this.courseQuota;
    }

    public void setCourseQuota(int courseQuota) {
        this.courseQuota = courseQuota;
    }

    public int getSessionCurrentStudentNumber() {
        return this.sessionCurrentStudentNumber;
    }

    public void setSessionCurrentStudentNumber(int sessionCurrentStudentNumber) {
        this.sessionCurrentStudentNumber = sessionCurrentStudentNumber;
    }

    public void incrementEnrolledStudentAmount(){
        setSessionCurrentStudentNumber(this.sessionCurrentStudentNumber+1);
    }
}
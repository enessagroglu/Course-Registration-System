import java.util.List;

public class CourseSession {
    private int sessionId;
    private Course course;
    private List<Schedule> scheduleList;

    public CourseSession(int sectionId, Course course, List<Schedule> scheduleList) {
        this.sessionId = sectionId;
        this.course = course;
        this.scheduleList = scheduleList;
    }


    public int getSessionId() {return sessionId;}

    public void setSessionId(int sessionId) {this.sessionId = sessionId;}

    public Course getCourse() {return course;}

    public void setCourse(Course course) {this.course = course;}

    public List<Schedule> getScheduleList() {return scheduleList;}

    public CourseSession setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
        return this;
    }

    @Override
    public String toString() {
        //This method returns a string representation of the CourseSession object
        return "CourseSession{" +
                "sessionId=" + sessionId +
                ", course=" + course +
                ", scheduleList=" + scheduleList +
                '}';
    }
}
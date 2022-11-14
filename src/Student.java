import java.util.ArrayList;

public class Student extends Person{
    private StudentID studentid;
    private Semester semester;
    private Advisor advisor;
    private Transcript transcript;
    private List<Course> selectedCourses = new ArrayList<Course>();
    private List<Course> selectedSessions = new ArrayList<Course>();
    private int entryYear;
    private Schedule schedule;

    public Student(){

    }


    public StudentID getStudentid() {
        return studentid;
    }

    public void setStudentid(StudentID studentid) {
        this.studentid = studentid;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public List<Course> getSelectedCourses() {
        return selectedCourses;
    }

    public void setSelectedCourses(List<Course> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }

    public List<Course> getSelectedSessions() {
        return selectedSessions;
    }

    public void setSelectedSessions(List<Course> selectedSessions) {
        this.selectedSessions = selectedSessions;
    }

    public int getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(int entryYear) {
        this.entryYear = entryYear;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;


    }
}

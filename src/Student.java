import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student extends Person{
    private Semester semester;
    private Advisor advisor;
    private Transcript transcript;
    private ArrayList<Course> selectedCourses = new ArrayList<Course>();
    private ArrayList<CourseSession> selectedSessions = new ArrayList<CourseSession>();
    private String entryYear;
    private Schedule schedule;

   public Student(String studentId, Semester semester, Advisor advisor, Transcript transcript, ArrayList<Course> selectedCourses,
                   ArrayList<CourseSession> selectedSessions, String entryYear, Schedule schedule) {
        this.semester = semester;
        this.advisor = advisor;
        this.transcript = transcript;
        this.selectedCourses = selectedCourses;
        this.selectedSessions = selectedSessions;
        this.entryYear = entryYear;
        this.schedule = schedule;
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

    public ArrayList<Course> getSelectedCourses() {
        return selectedCourses;
    }

    public void setSelectedCourses(ArrayList<Course> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }

    public List<CourseSession> getSelectedSessions() {
        return selectedSessions;
    }

    public void setSelectedSessions(ArrayList<CourseSession> selectedSessions) {
        this.selectedSessions = selectedSessions;
    }

    public String getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(String entryYear) {
        this.entryYear = entryYear;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }



    public void EnrollCourse(ArrayList<Course> allCourses, ArrayList<Course> TECourses, ArrayList<Course> FTECourses, ArrayList<Course> NTECourses){
        this.allCourses=allCourses;
        this.TECourses=TECourses;
        this.FTECourses=FTECourses;
        this.NTECourses=NTECourses;
        return EnrollCourse;
    }

    public ArrayList<Course> sendToApproval(ArrayList<Course> selectedCourses, ArrayList<CourseSession> selectedSessions){
        this.selectedCourses=selectedCourses;
        this.selectedSessions=selectedSessions;
        return sendToApproval;
    }

    public Schedule addSchedule(ArrayList<Course> selectedCourses){
        this.selectedSessions=selectedSessions;
        return addSchedule;
    }

    @Override
    public String getFullName() {
        return null;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    Boolean login(String userId, String password) {
        return null;
    }


    public static String createID(String studentEntryYear){



        Random random = new Random();


        return "1501" + studentEntryYear.substring(2,4) + Integer.toString(random.nextInt(999 - 1) + 1);
    }


}

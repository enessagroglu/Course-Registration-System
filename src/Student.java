import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student extends Person{
    private String studentId;
    private Semester semester;
    private Advisor advisor;
    private Transcript transcript;
  //  private List<Course> selectedCourses = new ArrayList<Course>();
    private List<CourseSession> selectedSessions = new ArrayList<CourseSession>();
    private String entryYear;
    private Schedule schedule;

   public Student(String studentId, Semester semester, Advisor advisor, Transcript transcript, List<Course> selectedCourses,
                   List<CourseSession> selectedSessions, String entryYear, Schedule schedule) {
        this.studentId = createID(entryYear);;
        this.semester = semester;
        this.advisor = advisor;
        this.transcript = transcript;
        this.selectedCourses = selectedCourses;
        this.selectedSessions = selectedSessions;
        this.entryYear = entryYear;
        this.schedule = schedule;
    }
    public Student(String entryYear){
        this.entryYear = entryYear;

    }



    public String getStudentId() {
        return createID(entryYear);
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public List<CourseSession> getSelectedSessions() {
        return selectedSessions;
    }

    public void setSelectedSessions(List<CourseSession> selectedSessions) {
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

 public boolean login(StudentID studentID, String password){
        this.studentid=studentID;
        this.password=password;
        return login;
    }

    public void EnrollCourse(List<Course> allCourses, List<Course> teAllCourses, List<Course> fteCourses, List<Course> nteCourses){
        this.allCourses=allCourses;
        this.allCourses=teAllCourses;
        this.allCourses=fteCourses;
        this.allCourses=nteCourses;
    }

    public List<Course> sendToApproval(List<Course> selectedCourses, List<CourseSession> selectedSessions){
        this.selectedCourses=selectedCourses;
        this.selectedSessions=selectedSessions;
        return sendToApproval;
    }

    public Schedule addSchedule(List<Course> selectedCourses){
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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student extends Person{
    private String name;
    private String studentId;
    private int semester;
    private Advisor advisor;
    private Transcript transcript;
    private List<Course> selectedCourses = new ArrayList<Course>();
    private List<CourseSession> selectedSessions = new ArrayList<CourseSession>();
    private String entryYear;
    private Schedule schedule;
    private ArrayList<String> allCourses;

    /*public Student(String studentId, Semester semester, String name, Advisor advisor, Transcript transcript, List<Course> selectedCourses,
                   List<CourseSession> selectedSessions, String entryYear, Schedule schedule) {
        this.name = name;
        this.studentId = createID(entryYear);;
        this.semester = Semester.semesterNoGenerate();
        this.advisor = advisor;
        this.transcript = transcript;
        this.selectedCourses = selectedCourses;
        this.selectedSessions = selectedSessions;
        this.entryYear = entryYear;
        this.schedule = schedule;
    }*/
    public ArrayList<String> Student(String entryYear){
        this.entryYear = entryYear;
        this.name = Person.getFullName();
        this.semester = getSemester();
        ArrayList<String> studentInfo = new ArrayList<String>();;
        studentInfo.add(name);
        studentInfo.add(entryYear);
        studentInfo.add(String.valueOf(semester));
        return studentInfo;
    }



    public String getStudentId() {
        return createID(entryYear);
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getSemester() {
        return Semester.semesterNoGenerate();
    }

    public void setSemester(int semester) {
        this.semester = Semester.semesterNo;
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

    /* public boolean login(Person name, String password){
         this.name=name;
         this.password=password;
         return login(a,55);
     }
 */
    public void EnrollCourse(List<Course> allCourses, List<Course> teAllCourses, List<Course> fteCourses, List<Course> nteCourses){
        this.allCourses=Course.allCourses;
        this.allCourses=Course.teAllCourses;
        this.allCourses=Course.fteCourses;
        this.allCourses=Course.nteCourses;
    }

    public List<Course> sendToApproval(List<Course> selectedCourses, List<CourseSession> selectedSessions){
        this.selectedCourses=selectedCourses;
        this.selectedSessions=selectedSessions;
        return sendToApproval(selectedCourses,selectedSessions);
    }

    public Schedule addSchedule(List<Course> selectedCourses){
        this.selectedSessions=selectedSessions;
        return addSchedule(selectedCourses);
    }

    /*@Override
    public String getFullName() {
        return null;
    }*/

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
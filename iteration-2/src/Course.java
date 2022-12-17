import java.util.ArrayList;

public class Course{

    private String courseId;
    private String name;
    private int quota;
    private int credit;
    private Semester semester;
    private List<Student> students = new ArrayList<>();

    private List<Course> prerequisites = new ArrayList<>();
    private CourseSession session;


    public String getCourseId() {return courseId;}

    public void setCourseId(String courseId) {this.courseId = courseId;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getQuota() {return quota;}

    public void setQuota(int quota) {this.quota = quota;}

    public int getCredit() {return credit;}

    public void setCredit(int credit) {this.credit = credit;}

    public Semester getSemester() {return semester;}

    public void setSemester(Semester semester) {this.semester = semester;}

    public List<Student> getStudents() {return students;}

    public void setStudents(List<Student> students) {this.students = students;}

    public List<Course> getPrerequisites() {return prerequisites;}

    public void setPrerequisites(List<Course> prerequisites) {this.prerequisites = prerequisites;}

    public CourseSession getSession() {return session;}

    public void setSession(CourseSession session) {this.session = session;}
    protected Course(String courseId, String name, int quota, int credit, Semester semester) {
        this.courseId = courseId;
        this.name = name;
        this.quota = quota;
        this.credit = credit;
        this.semester = semester;
    }

    protected Course(String courseId, String name, int quota, int credit {
        this.courseId = courseId;
        this.name = name;
        this.quota = quota;
        this.credit = credit;
    }

    public void addStudentToArraylist(Student student) {
        List<Student> students = this.students;
        students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", instructor=" + instructor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;

        Course course = (Course) o;

        return getCourseId().equals(course.getCourseId());
    }

    @Override
    public int hashCode() {
        return getCourseId().hashCode();
    }


}
public class ProjectChecker extends Checker{
    private Course course;

    public ProjectChecker(Student student, Course course) {
        super(student);
        this.course = course;
    }

    public Course getCourse() {return course;}

    public void setCourse(Course course) {this.course = course;}

    @Override
    public Course raiseCourse() {return course;}

    @Override
    public String checkerMessage() {return course.getCourseId() + " because student completed credits < 165";}
}
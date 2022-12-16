public class GraduateChecker extends Checker{
    private Course course;

    public GraduateChecker(Student student, Course course) {
        super(student);
        this.course = course;
    }

    public Course getCourse() {return course;}

    public void setCourse(Course course) {this.course = course;}

    @Override
    public Course raiseCourse() {return course;}

    @Override
    public String checkerMessage() {
        return course.getCourseId() + " Students are unable to enroll in FTE course for the fall semester unless they are graduating in that semester.";
    }
}
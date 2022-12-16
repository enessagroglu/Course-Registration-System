public class QuotaChecker extends Checker{
    private Course course;

    public QuotaChecker(Student student, Course course) {
        super(student);
        this.course = course;
    }
    public Course getCourse() {return course;}

    public void setCourse(Course course) {this.course = course;}

    @Override
    public Course raiseCourse() {return course;}

    @Override
    public String checkerMessage() {return "Could not register for " + course.getCourseId() + " because of a quota problem.";}
}

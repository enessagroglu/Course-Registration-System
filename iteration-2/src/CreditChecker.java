public class CreditChecker extends Checker{
    private Course course;

    public CreditChecker(Student student, Course course) {
        super(student);
        this.course = course;
    }

    public Course getCourse() {return course;}

    public void setCourse(Course course) {this.course = course;}

    @Override
    public Course raiseCourse() {return course;}

    @Override
    public String raiseError() {return "Could not register to " + course.getCourseId() + " because completed credits < 155";}
}
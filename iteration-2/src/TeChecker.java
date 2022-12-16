public class TeChecker extends Checker {
    private Course course;

    public TwoTechnicalElectiveError(Student student, Course course) {
        super(student);
        this.course = course;
    }

    public Course getCourse() {return course;}

    public void setCourse(Course course) {this.course = course;}

    @Override
    public Course raiseCourse() {return course;}

    @Override
    public String raiseError() {return "Could not register" + course.getCourseId() + " because only 2 TE can be taken.";}
}

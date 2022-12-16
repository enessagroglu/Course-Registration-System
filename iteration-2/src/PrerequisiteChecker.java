public class PrerequisiteChecker extends Checker{
    private Course course;
    private Course prereq;

    public PrerequisiteChecker(Student student, Course course, Course prereq) {
        super(student);
        this.course = course;
        this.prereq = prereq;
    }

    public Course getCourse() {return course;}

    public void setCourse(Course course) {this.course = course;}

    public Course getPrereq() {return prereq;}

    public void setPrereq(Course prereq) {this.prereq = prereq;}

    @Override
    public Course raiseCourse() {return course;}

    @Override
    public String checkerMessage() {return "You can not take "+course.getCourseId()+" because you failed prerequisite "+ required.getCourseId();}
}
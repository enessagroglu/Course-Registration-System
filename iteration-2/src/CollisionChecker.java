public class CollisionChecker extends Checker{
    private Course firstCourse;
    private Course secondCourse;

    public CollisionChecker(Course firstCourse, Course secondCourse) {
        this.firstCourse = firstCourse;
        this.secondCourse = secondCourse;
    }

    public Course getFirstCourse() {return firstCourse;}

    public void setFirstCourse(Course firstCourse) {this.firstCourse = firstCourse;}

    public Course getSecondCourse() {return secondCourse;}

    public void setSecondCourse(Course secondCourse) {this.secondCourse = secondCourse;}
    @Override
    public Course raiseCourse() {return secondCourse;}

    @Override
    public String checkerMessage() {return secondCourse.getName()+" collision with "+firstCourse.getName()+" in schedule";}
}
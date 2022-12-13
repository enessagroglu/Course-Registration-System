import java.util.ArrayList;

public class MandatoryCourse extends Course{

    public MandatoryCourse() {
    }
    //This constructor will initialize the attributes of the MandatoryCourse class by calling the superclass
    // constructor and passing in the values for the attributes.

    public MandatoryCourse(String courseId, String name, int quota, int credit, Semester semester) {
        super(courseId, name, quota, credit, semester);
    }

    @Override
    public String toString() {
        return "MandatoryCourse{} " + super.toString();
    }
}

public class NT_UCourse extends ElectiveCourse{

    public NT_UCourse() {
        super();
    }

    public NT_UCourse(String courseId, String name, int quota, int credit) {
        super(courseId, name, quota, credit);
    }
    @Override
    public String toString() {
        return "NT_UCourse{} " + super.toString();
    }
}

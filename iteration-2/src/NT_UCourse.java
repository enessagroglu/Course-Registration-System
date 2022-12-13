public class NT_UCourse extends ElectiveCourse{//NT_UElective class extends from ElectiveCourse class, it created for NT_UE elective courses

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

public class FacultyTechnicalCourse extends ElectiveCourse{

    public FacultyTechnicalCourse(String courseId, String name, int quota, int credit) {
        super(courseId, name, quota, credit);
    }
    @Override
    public String toString() {
        return "FacultyTechnicalCourse{} " + super.toString();
    }
}

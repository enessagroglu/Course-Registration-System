public class TechnicalCourse extends ElectiveCourse {
    private final int minimumCredit = 155;
    //The final modifier indicates that the value of the field cannot be changed once
    // it is initialized. In other words, the field has a constant value.

    public TechnicalCourse(String courseId, String name, int quota, int credit) {
        super(courseId, name, quota, credit);
    }

    public int getMinimumCredit() {
        return minimumCredit;
    }

    @Override
    public String toString() {
        return "TechnicalCourse{} " + super.toString();
    }
}

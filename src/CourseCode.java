public class CourseCode{
    // Attributes
    private String departmentCode;
    private String courseID;

    // Constructor
    public CourseCode(String departmentCode, String courseID) {
        this.departmentCode = departmentCode;
        this.courseID = courseID;
    }

    // Getter and setter methods
    public String getDepartmentCode() {
        return this.departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getCourseID() {
        return this.courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
}
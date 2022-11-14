public class CourseCode {

    private String departmentCode;
    private String courseID;


    public CourseCode(String departmentCode, String courseID) {
        this.departmentCode = departmentCode;
        this.courseID = courseID;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
}

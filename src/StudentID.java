public class StudentID {
    private String studentDepartment;
    private String studentEntryYear;
    private String studentEntryOrder;
    private Student student;

    public StudentID(String studentDepartment, String studentEntryYear,
                     String studentEntryOrder, Student student) {
        this.studentDepartment = studentDepartment;
        this.studentEntryYear = studentEntryYear;
        this.studentEntryOrder = studentEntryOrder;
        this.student = student;
    }

    public String getStudentDepartment() {
        return studentDepartment;
    }

    public void setStudentDepartment(String studentDepartment) {
        this.studentDepartment = studentDepartment;
    }

    public String getStudentEntryYear() {
        return studentEntryYear;
    }

    public void setStudentEntryYear(String studentEntryYear) {
        this.studentEntryYear = studentEntryYear;
    }

    public String getStudentEntryOrder() {
        return studentEntryOrder;
    }

    public void setStudentEntryOrder(String studentEntryOrder) {
        this.studentEntryOrder = studentEntryOrder;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String createID(){
        return createID;
    }


}

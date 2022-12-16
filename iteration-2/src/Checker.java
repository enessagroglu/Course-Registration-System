public abstract class Checker {
    private Student student;

    protected Checker(Student student) {this.student = student;}

    public Student getStudent() {return student;}

    public void setStudent(Student student) {this.student = student;}

    public Course raiseCourse(){return null;}

    public String checkerMessage(){return "Checker Message";}
}

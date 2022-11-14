public class Schedule {
    private boolean status;
    private SemesterName semesterName;

    public Schedule(boolean status, SemesterName semesterName){
        this.status = status;
        this.semesterName = semesterName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public SemesterName getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(SemesterName semesterName) {
        this.semesterName = semesterName;
    }

    public void createSchedule(List <Course> selectedCourses){}




}



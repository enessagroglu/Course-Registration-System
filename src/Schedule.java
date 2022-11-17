import java.util.List;

public class Schedule {
    private boolean status;
    private String semesterName;

    public Schedule(boolean status, String semesterName){
        this.status = status;
        this.semesterName = semesterName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



    public void createSchedule(List<Course> selectedCourses){}




}


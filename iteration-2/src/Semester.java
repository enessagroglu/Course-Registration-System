import java.util.ArrayList;
import java.util.List;

public class Semester {
    private int semesterId;
    private List<Course> courses = new ArrayList<>();
    private String season;

    public Semester(int semesterId, String season) {
        this.semesterId = semesterId;
        this.season = season;
    }

    public int getSemesterId() {return semesterId;}

    public void setSemesterId(Integer semesterId) {this.semesterId = semesterId;}

    public List<Course> getCourses() {return courses;}

    public void setCourses(List<Course> courses) {this.courses = courses;}

    public String getSeason() {return season;}

    public void setSeason(String season) {this.season = season;}


    public void addCourse(Course course) {courses.add(course);}
    @Override
    public boolean equals(Object o) {
        // If the two objects are the same object, return true.
        // This check is necessary because we want to ensure that the objects are actually
        // the same object and not just two objects with the same data.
        if (this == o) return true;
        // If the object passed as an argument is not an instance of the Semester class,
        // return false. This check is necessary because we only want to compare Semester
        // objects, not objects of other types.
        if (!(o instanceof Semester)) return false;
        // Cast the object passed as an argument to the Semester type so that we can access
        // its fields and methods.
        Semester semester = (Semester) o;
        // Compare the semesterId field of the two Semester objects. If they are equal,
        // return true. Otherwise, return false.
        return getSemesterId().equals(semester.getSemesterId());
    }

    @Override
    public int hashCode() {return getSemesterId().hashCode();}

    @Override
    public String toString() {
        return "Semester{" + "semesterId=" + semesterId + '}';
    }
}

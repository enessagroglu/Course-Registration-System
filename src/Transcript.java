import java.util.ArrayList;
public class Transcript {
   private ArrayList<Course> passedCourses;
   private ArrayList<Course> failedCourses;
   private int totalCredits;
   private float gpa;
   private int semesterNumber;

   public ArrayList<Course> getPassedCourses() {
      return passedCourses;
   }

   public void setPassedCourses(ArrayList<Course> passedCourses) {
      this.passedCourses = passedCourses;
   }

   public ArrayList<Course> getFailedCourses() {
      return failedCourses;
   }

   public void setFailedCourses(ArrayList<Course> failedCourses) {
      this.failedCourses = failedCourses;
   }

   public int getTotalCredits() {
      return totalCredits;
   }

   public void setTotalCredits(int totalCredits) {
      this.totalCredits = totalCredits;
   }

   public float getGpa() {
      return gpa;
   }

   public void setGpa(float gpa) {
      this.gpa = gpa;
   }

   public int getSemesterNumber() {
      return semesterNumber;
   }

   public void setSemesterNumber(int semesterNumber) {
      this.semesterNumber = semesterNumber;
   }
}
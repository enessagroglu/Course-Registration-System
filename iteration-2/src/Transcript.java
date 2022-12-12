import java.util.*;
public class Transcript {
   private Map<String, Object> hashMapTranscript;
   private Student student;
   private int credit;
   private int grade;
   private int cumulativeCredit;
   private int cumulativeGrade;

   public Map<String, Object> getHashMapTranscript() {
      return hashMapTranscript;
   }

   public void setHashMapTranscript(Map<String, Object> hashMapTranscript) {
      this.hashMapTranscript = hashMapTranscript;
   }

   public Student getStudent() {
      return student;
   }

   public void setStudent(Student student) {
      this.student = student;
   }

   public int getCredit() {
      return credit;
   }

   public void setCredit(int activeCredit) {
      this.credit = credit;
   }

   public int getGrade() {
      return grade;
   }

   public void setGrade(int grade) {
      this.grade = grade;
   }

   public int getCumulativeCredit() {
      return cumulativeCredit;
   }

   public void setCumulativeCredit(int cumulativeCredit) {
      this.cumulativeCredit = cumulativeCredit;
   }

   public int getCumulativeGrade() {
      return cumulativeGrade;
   }

   public void setCumulativeGrade(int cumulativeGrade) {
      this.cumulativeGrade = cumulativeGrade;
   }

   public Transcript(Student student) {
      this.student = student;
      this.hashMapTranscript = new HashMap<>();
      this.hashMapTranscript.put("ID", student.getId());
      this.hashMapTranscript.put("Name", student.getName());
      this.hashMapTranscript.put("Surname", student.getSurname());
      this.hashMapTranscript.put("Email", student.getEmails());
      this.hashMapTranscript.put("Advisor", student.getAdvisor().getFullName());
      Semester semester = student.getSemester();
      AppendSemester(semester);

   }

   public Map<String, Object> createSemester() {
      //Creating new semester and puts courses as HashMap
      Map<String, Object> hashMapsemester = new HashMap<>();
      hashMapsemester.put("Courses", new HashMap<String, Object>());
      return hashMapsemester;
   }

   public void AppendSemester(Semester semester) {
      // Create a map for the semester information
      Map<String, Object> hashMapsemester = createSemester();

      // Add the semester information to the map
      String semesterString = "Semester".concat(semester.getSemesterId().toString());
      hashMapTranscript.put(semesterString, hashMapsemester);

   }
   public void addCourse(Course course) {
      // Get the semester name and semester hash map
      String semesterName = "Semester".concat(getStudent().getSemester().getSemesterId().toString());
      Map<String, Object> HMsemester = hashMapTranscript.get(semesterName);

      // Get the course map from the semester hash map
      Map<String, Object> HMcourse = (HashMap<String, Object>) hashMapsemester.get("Courses");

      // Get the letter grade for the course from the student's hash map
      String letterGrade = student.getHashMapGrade().get(course).getLetterGrade();

      // Add the course and its letter grade to the course hash map
      HMcourse.put(course.getCourseId(), letterGrade);
   }

   // This method adds a student's GPA to their transcript
   public void addGPA(){
      // Create a string containing the semester name
      String semesterName = "Semester".concat(getStudent().getSemester().getSemesterId().toString());

      // Retrieve the semester map from the transcript map
      Map<String, Object> HMsemester = (HashMap<String, Object>) hashMapTranscript.get(semesterName);

      // Get the student's GPA
      float GPA = student.getGpa();

      // Round the GPA to two decimal places
      double roundOff = (double) Math.round(GPA * 100) / 100;

      // Add the student's active credit and GPA to the semester map
      HMsemester.put("ActiveCredit",credit);
      HMsemester.put("GPA",roundOff);
   }

}
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RegisterSystem {

    private Student studentObject;
    private Random randomNumberGenerator = new Random();
    private Advisor advisor;
    private CourseController courseController;

    public Registrator() {

    }

    public Registrator(Student studentObject, CourseController courseController) {

        this.advisor = new Advisor(studentObject);

        this.studentObject = studentObject;

        this.courseController = courseController;

    }

    public Student getStudent() {
        return studentObject;
    }

    public void setStudent(Student student) {
        this.studentObject = student;
    }

    public Random getRandomGenerator() {
        return randomNumberGenerator;
    }

    public void setRandomGenerator(Random randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public CourseController getCourseController() {
        return courseController;
    }

    public void setCourseController(CourseController courseController) {
        this.courseController = courseController;
    }

    public void selectCourse(Course courses) {
        studentObject.addCourseToSelectedCourses(courses);
    }

    //This method updates the student's transcript and GPA information for the next semester,
// including setting the cumulative grade, adding the GPA to the transcript, setting the active credit and GPA in the
// student object to 0, calculating the cumulative GPA, setting the semester in the student object,
// and adding the semester to the student transcript. It also clears the list of active courses for
// the student and handles any potential NullPointerExceptions.
    public void assignNextSemester(Student student,Semester semester) {
        try {
            // Create variables to store the current grade and accumulated grade for the student
            double accumulatedGrade;
            double currentGrade;
            // Get the student's transcript
            Transcript studentTranscript;

            // Assign the student's transcript and current grade to the corresponding variables
            studentTranscript = student.getTranscript();
            currentGrade = studentTranscript.getActiveGrade();
            // Add the current grade to the accumulated grade
            accumulatedGrade = studentTranscript.getCumulativeGrade() + currentGrade;

            // Set the accumulated grade in the transcript
            studentTranscript.setCumulativeGrade(accumulatedGrade);
            // Calculate the student's GPA for the current semester
            student.calculateGPA();
            // Set the current grade in the transcript to 0
            studentTranscript.setActiveGrade(0);

            // Add the GPA to the transcript
            studentTranscript.addGPA();
            // Set the active credit in the transcript to 0
            studentTranscript.setActiveCredit(0);
            // Set the student's GPA to 0
            student.setGpa(0);
            // Calculate the student's cumulative GPA
            student.calculateCGPA();
            // Set the new semester for the student
            student.setSemester(semester);
            // Add the new semester to the student's transcript
            studentTranscript.addSemester(semester);
            // Get the list of active courses for the student
            List<Course> activeCourses = student.getActiveCourses();
            // Clear the list of active courses
            activeCourses.clear();

        } catch(NullPointerException e){
            // Do nothing if a null pointer exception is caught
        }
    }
    /* This method adds courses from the student's course basket to their active courses, updating the student's transcript to reflect the added courses.
    It first retrieves the student object, student transcript, course basket, and list of failed courses for the student. It then iterates through the course basket
    and adds the courses to the active courses list. If a course is in the list of failed courses, the method updates the active and cumulative credit in the student
    transcript to remove the credit for that course. The method then removes all courses in the course basket from the list
    of failed courses, and updates the active and cumulative credit in the student transcript to reflect the addition
     of the courses in the course basket. Finally, the method adds the student to the list of students for each course in
     the course basket and clears the course basket.*/
    public void selectCourseToActiveCourse() {
        // Get the student object and the student's transcript
        Student student;
        Transcript studentTranscript;
        // Get the list of selected courses in the student's basket
        List<Course> selectedCourse;
        // Get the list of courses that the student has failed
        List<Course> unsuccessful;

        student = this.studentObject;
        studentTranscript = student.getTranscript();
        selectedCourse = student.getCourseBasket();
        unsuccessful = student.getFailedCourses();

        // Loop through the list of selected courses
        for(int i=0; i<selectedCourse.size(); i++){
            Course course = selectedCourse.get(i);
            // If the student has failed the course before, decrease the active credit and increase the cumulative credit in the transcript
            if (unsuccessful.contains(course)){
                double currentGrade;
                double accumulatedGrade;

                currentGrade = studentTranscript.getActiveCredit();
                currentGrade += course.getCredit();
                studentTranscript.setActiveCredit(currentGrade);

                accumulatedGrade = studentTranscript.getCumulativeCredit();
                accumulatedGrade -= course.getCredit();
                studentTranscript.setCumulativeCredit(accumulatedGrade);
            }
        }

        // Remove the selected courses from the list of failed courses
        unsuccessful.removeAll(selectedCourse);

        // Get the list of active courses for the student
        List<Course> activeCourses = student.getActiveCourses();
        // Add the selected courses to the list of active courses
        activeCourses.addAll(selectedCourse);

        // Loop through the list of selected courses
        for(int i=0; i<selectedCourse.size(); i++){
            Course course = selectedCourse.get(i);

            double currentGrade;
            double accumulatedGrade;

            // Increase the active credit and cumulative credit in the transcript
            currentGrade = studentTranscript.getActiveCredit();
            currentGrade += course.getCredit();
            studentTranscript.setActiveCredit(currentGrade);

            accumulatedGrade = studentTranscript.getCumulativeCredit();
            accumulatedGrade += course.getCredit();
            studentTranscript.setCumulativeCredit(accumulatedGrade);
            // Add the student to the list of students enrolled in the course
            course.addStudentToArraylist(student);
        }
        // Clear the student's basket of selected courses
        selectedCourse.clear();
    }
    /* This method selects a random elective course for the student, with the type of elective depending on the input course.
     It generates a random number and uses it to select a course from the appropriate list of elective courses, which is
      the list of technical electives, NT/U electives, or faculty technical electives. The method then checks if the selected
      course is approved by the student's advisor, and if not, it continues to select a new random course until an approved
      course is selected. The approved course is then returned.*/
    // This method selects a random elective course from the given list of elective courses
    public Course selectRandomElective(Course course) {
        // Generate a random number
        int element;
        // Initialize a variable to store the selected elective course
        Course electiveCourse = null;

        // Keep looping until the advisor approves the selected elective course
        while (!advisor.approveCourse(electiveCourse)){
            // If the given course is a Technical Elective, select a random course from the list of technical electives
            if (course instanceof TechnicalElective) {
                element = randomNumberGenerator.nextInt(courseController.getTechnicalList().size());
                electiveCourse = courseController.getTechnicalList().get(element);
                // If the given course is a NT_U Elective, select a random course from the list of NT_U electives
            } else if (course instanceof NT_UElective) {
                element = randomNumberGenerator.nextInt(courseController.getNT_UList().size());
                electiveCourse = courseController.getNT_UList().get(element);
                // If the given course is a Faculty Technical Elective, select a random course from the list of faculty technical electives
            } else if (course instanceof FacultyTechnicalElective) {
                element = randomNumberGenerator.nextInt(courseController.getFacultyTechnicalList().size());
                electiveCourse = courseController.getFacultyTechnicalList().get(element);
            }
        }
        // Return the selected elective course
        return electiveCourse;
    }

    // This method starts the registration process for a student
    public void startRegistration() {
        // Get the current semester for the student
        Semester semester;
        // Get the list of courses that the student has not taken yet
        List<Course> notTakenList;
        // Create an iterator to loop through the list of not taken courses
        Iterator<Course> iteration;

        semester = studentObject.getSemester();

        // Loop through the list of failed courses for the student
        // If the advisor approves the course, add it to the student's basket
        for(int i=0; i<studentObject.getFailedCourses().size(); i++){
            Course course = studentObject.getFailedCourses().get(i);
            if (advisor.approveCourse(course)) {
                selectCourse(course);
            }
        }

        // Assign the list of not taken courses to the notTakenList variable
        notTakenList = studentObject.getNonTakenCourses();
        // Assign the iterator to the notTakenList
        iteration = notTakenList.iterator();

        // Loop through the list of not taken courses
        while (iteration.hasNext()) {
            Course next = iteration.next();
            // If the course is an elective course, select a random elective course
            if (next instanceof ElectiveCourse) {
                Course course = selectRandomElective(next);

                // If the advisor approves the selected elective course, add it to the student's basket and remove it from the list of not taken courses
                if (advisor.approveCourse(course)) {
                    selectCourse(course);
                    iteration.remove();
                }
                // If the course is not an elective course, check if the advisor approves it
            } else if(advisor.approveCourse(next)) {
                // If the advisor approves the course, add it to the student's basket and remove it from the list of not taken courses
                selectCourse(next);
                iteration.remove();
            }
        }

        // Loop through the list of courses offered in the current semester
        for(int i=0; i<semester.getCourseList().size(); i++){
            Course course = semester.getCourseList().get(i);

            // If the course is an elective course, select a random elective course
            if (course instanceof ElectiveCourse) {
                Course elective = selectRandomElective(course);
                selectCourse(elective);
                // If the course is not an elective course, check if the advisor approves it
            } else if (advisor.approveCourse(course)) {
                // If the advisor approves the course, add it to the student's basket
                selectCourse(course);
            }
        }

        // Get the student's advisor
        Instructor educator = studentObject.getAdvisor();
        // Have the advisor approve the student's basket of selected courses
        educator.approveStudentBasket(studentObject);
        // Move the selected courses from the student's basket to the list of active courses
        selectCourseToActiveCourse();
    }

}


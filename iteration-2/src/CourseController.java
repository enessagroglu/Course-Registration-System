import java.util.*;

public class CourseController {
    private List<Course> courses = new ArrayList<>();
    private List<Course> mandatoryCourses = new ArrayList<>();
    private List<ElectiveCourse> facultyTechnicalCourses = new ArrayList<>();
    private List<ElectiveCourse> NT_UCourses = new ArrayList<>();
    private List<ElectiveCourse> technicalCourses = new ArrayList<>();
    private Map<Integer, Semester> HMsemester = new HashMap<>();


    public List<Course> getCourses() {return courses;}

    public void setCourses(List<Course> courses) {this.courses = courses;}

    public List<Course> getMandatoryCourses() {return mandatoryCourses;}

    public void setMandatoryCourses(List<Course> mandatoryCourses) {this.mandatoryCourses = mandatoryCourses;}

    public List<ElectiveCourse> getFacultyTechnicalCourses() {return facultyTechnicalCourses;}

    public void setFacultyTechnicalCourses(List<ElectiveCourse> facultyTechnicalCourses) {this.facultyTechnicalCourses = facultyTechnicalCourses;}

    public List<ElectiveCourse> getNT_UCourses() {return NT_UCourses;}

    public void setNT_UCourses(List<ElectiveCourse> NT_UCourses) {this.NT_UCourses = NT_UCourses;}

    public List<ElectiveCourse> getTechnicalCourses() {return technicalCourses;}

    public void setTechnicalCourses(List<ElectiveCourse> technicalCourses) {this.technicalCourses = technicalCourses;}

    public Map<Integer, Semester> getHMsemester() {return HMsemester;}

    public void setHMsemester(Map<Integer, Semester> HMsemester) {this.HMsemester = HMsemester;}

    public CourseExpert() {
        createSemester();
    }


    public void createSemester() {

        // Loop through the semesters (1-8)
        for (int i = 1; i < 9; i++) {
            int semesterId = i; // Set the semester ID

            // Determine the season based on the semester ID
            String season;
            if (i % 2 == 1)
                season = "Fall";
            else season = "Spring";

            // Add the semester to the map
            this.HMsemester.put(semesterId, new Semester(semesterId, season));
        }
    }

    public void removeStudentsFromCourses(){
        for(Course course: courses) {
            course.getStudents().clear();
        }
    }

    public void addMandatoryCourse(Course course){
        List<Course> mandatoryCourses = this.mandatoryCourses;
        mandatoryCourses.add(course);
    }
    public void addNTUCourse(ElectiveCourse electiveCourse){
        List<ElectiveCourse> NT_UCourses = this.NT_UList;
        NT_UCourses.add(electiveCourse);
    }
    public void addTechnicalCourse(ElectiveCourse electiveCourse){
        List<ElectiveCourse> technicalCourses = this.technicalCourses;
        technicalCourses.add(electiveCourse);
    }

    public void addFacultyTechnicalCourse(ElectiveCourse electiveCourse) {
        List<ElectiveCourse> facultyTechnicalCourses = this.facultyTechnicalCourses;
        facultyTechnicalCourses.add(electiveCourse);
    }
    public void printMandatoryCourses() {
        List<Course> mandatoryCourseList = mandatoryCourses;
        int i = 0;
        while (i < mandatoryCourseList.size()) {
            Course mandatoryCourse = mandatoryCourseList.get(i);
            System.out.println(mandatoryCourse);
            i++;
        }
    }

    public void printTechnicalElectiveCourses() {
        List<ElectiveCourse> electiveCourseList = technicalCourses;
        int i = 0;
        while (i < electiveCourseList.size()) {
            ElectiveCourse electiveCourse = electiveCourseList.get(i);
            System.out.println(electiveCourse);
            i++;
        }
    }

    public void printNT_UCourses() {
        List<ElectiveCourse> electiveCourseList = NT_UCourses;
        int i = 0;
        while (i < electiveCourseList.size()) {
            ElectiveCourse electiveCourse = electiveCourseList.get(i);
            System.out.println(electiveCourse);
            i++;
        }
    }

    public void printFacultyTechnicalCourses() {
        List<ElectiveCourse> electiveCourseList = facultyTechnicalCourses;
        int i = 0;
        while (i < electiveCourseList.size()) {
            ElectiveCourse electiveCourse = electiveCourseList.get(i);
            System.out.println(electiveCourse);
            i++;
        }
    }

    public void addPrerequisiteCourse(Course course, Course prerequisiteCourse) {
        course.getPrerequisites().add(prerequisiteCourse);
    }

    public Session createSession(int sessionId, Course course, List<Schedule> scheduleList) {
        return new Session(sessionId, course, scheduleList);
    }

    public void addSession(Session session) {
        Course course = session.getCourse();
        course.setSession(session);
    }

    public ElectiveCourse createElectiveCourse(String type,String courseId, String name, int quota, int credit){
        // This method creates an ElectiveCourse object of a specified type, with the given course ID, name,
        // capacity, and credit.
        if (type == null){
            // If the given type is null, the method prints an error message and returns null.
            System.out.println("Invalid type...");
            return null;
        }
        if(type.equalsIgnoreCase("NTE-UE")){
            // If the given type is "NTE-UE", the method creates an NT_UElective object and adds it to the list
            // of NTE-UE courses, unless the course ID is "NTExxx" or "UE". In that case, the method just returns
            // the created object without adding it to the list of courses.
            ElectiveCourse nt_uCourse = new NT_UElective(courseId, name, quota, credit);
            if(!(courseId.equals("NTExxx") || courseId.equals("UE")))
                addNTUCourse(nt_uCourse);
            return nt_uCourse;
        }
        else if (type.equalsIgnoreCase("TE")){
            // If the given type is "TE", the method creates a TechnicalElective object and adds it to the list
            // of TE courses, unless the course ID is "TExxx". In that case, the method just returns the created
            // object without adding it to the list of courses.
            ElectiveCourse technicalCourse = new TechnicalElective(courseId, name, quota, credit);
            if(!courseId.equals("TExxx"))
                addTechnicalCourse(technicalCourse);
            return technicalCourse;
        }
        else if (type.equalsIgnoreCase("FTE")){
            // If the given type is "FTE", the method creates a FacultyTechnicalElective object and adds it to
            // the list of FTE courses, unless the course ID is "FTExxx". In that case, the method just returns
            // the created object without adding it to the list of courses.
            ElectiveCourse facultyTechnicalCourse = new FacultyTechnicalElective(courseId, name, quota, credit);
            if(!courseId.equals("FTExxx"))
                addFacultyTechnicalCourse(facultyTechnicalCourse);
            return facultyTechnicalCourse;
        }
        // If the given type is none of the above, the method returns null.
        return null;
    }

    public Course createMandatoryCourse(String courseId, String name, int quota, int credit, String type, int semesterId){
        // This method creates a Course object of a specified type, with the given course ID, name, quota, credit, and semester ID.
        Course mandatoryCourse;
        Map<Integer,Semester> HMsemester = this.HMsemester;
        Semester semester = HMsemester.get(Integer.valueOf(semesterId));
        if(type.equals("Mandatory")){
            // If the given type is "Mandatory", the method creates a MandatoryCourse object and adds it to the
            // list of mandatory courses, and to the given semester.
            mandatoryCourse = new MandatoryCourse(courseId,name,quota,credit,semester);
            addMandatoryCourse(mandatoryCourse);
            semester.addCourse(mandatoryCourse);
            return mandatoryCourse;
        }
        else{
            // If the given type is not "Mandatory", the method calls the createElectiveCourse() method to create
            // an ElectiveCourse object of the specified type, and adds it to the list of mandatory courses, and
            // to the given semester.
            ElectiveCourse electiveCourse = createElectiveCourse(type, courseId, name, quota, credit);
            addMandatoryCourse(electiveCourse);
            semester.addCourse(electiveCourse);
            return electiveCourse;
        }

    }

    public Course searchCourse(String courseId){
        Course course = courses.stream()
                .filter(courseTmp -> courseId.equals(courseTmp.getCourseId()))
                //filter() method to create a new stream that contains only the
                // elements of the original stream that match the given courseId.
                .findAny()
                //findAny() method is used to return an element from the stream,
                // if it exists. If the stream is empty, the orElse() method is used to return null instead
                .orElse(null);
        return course;
    }


}
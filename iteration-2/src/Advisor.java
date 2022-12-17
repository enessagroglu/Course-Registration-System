import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;


public class Advisor extends Person{
    private String Name;
    private Student student;
    private Course course;
    private List<Student> client = new ArrayList<>();
    private List<Course> givenCourses = new ArrayList<>();
    private Map<String,Advisor> hmAdvisor;

    public Advisor(int id, String name, String surname, List<String> emails) {
        super(id, name, surname, emails);
        this.fullName = name + " " + surname;
    }

    public Advisor(int id, String name, String surname) {
        super(id, name, surname);
        this.fullName = name + " " + surname;
    }


    public Approver(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    public String Name() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public List<Student> getClient() {
        return client;
    }

    public void setClient(List<Student> client) {
        this.client = client;
    }

    public List<Course> getGivenCourses() {
        return givenCourses;
    }

    public void setGivenCourses(List<Course> givenCourses) {
        this.givenCourses = givenCourses;
    }

    public void addGivenCourse(Course course) {
        givenCourses.add(course);
    }

    public void addClient(Student student) {
        client.add(student);
    }



    public boolean getElectiveCourseCheck(){
        List<Course> pastCourses = student.getPastCourses();
        List<Course> selectedCourses = student.getSelectedCourses();

        if(pastCourses.contains(course)){return false;}
        else if(selectedCourses.contains(course)){return false;}
        else return true;
    }






    public boolean prerequisiteCheck(){
        List<Course> pastCourses = student.getPastCourses();
        List<Course> prerequisiteCourses = course.getPrerequisites();
        boolean check = true;

        for(Course need : prerequisiteCourses){
            if(!pastCourses.contains(need)){
                PrerequisiteError prerequisiteError = new PrerequisiteError(student,course,require);
                check=false;
            }
        }
    }





    public boolean quotaCheck(){
        int quota = course.getquota;
        List<Student> studentList = course.getStudents();

        if(capacity>studentList.size()){
            return true;
        }
        else{
            QuotaChecker quotaChecker = new QuotaChecker(student,course);
            return false;
        }
    }

    //Approve method checks all the conditions are approved or not
    public boolean Approve(Course course){
        boolean getElectiveCourseCheck;
        boolean quotaCheck;
        boolean prerequisiteCheck;
        this.course=course;

        if(course instanceof ElectiveCourse){
            quotaCheck=quotaCheck();
            getElectiveCourseCheck=getElectiveCourseCheck();
        }
        prerequisiteCheck=prerequisiteCheck();
        return quotaCheck && getElectiveCourseCheck && prerequisiteCheck;

    }


    public void FTECheck(Student student) {
        List<Course> SelectedCourses = student.getSelectedCourses();
        Course course = null;
        for (Course src : SelectedCourses) {
            if (src instanceof FacultyTechnicalElective) {
                course = src;
                break;
            }
        }
        if (course != null) {
            SelectedCourses.remove(course);
            Error notInGraduationError = new NotInGraduationError(student, course);
            student.addNonTakenCourse(new FacultyTechnicalElective());
            student.addError(notInGraduationError);
        }
    }

    public void TECheck(Student student) {
        List<Course> courseBasket = student.getCourseBasket();
        int count = 0;
        for (int i = 0; i < courseBasket.size(); i++) {
            Course course = courseBasket.get(i);
            if (course instanceof TechnicalElective) {
                count++;
                if (count > 2) {
                    Error technicalElectiveError = new TwoTechnicalElectiveError(student, course);
                    student.addNonTakenCourse(new TechnicalElective());
                    student.addError(technicalElectiveError);
                    courseBasket.remove(i);
                    i--;
                    count--;
                }
            }
        }
    }


    public void graduationProjectCheck(Student student) {
        List<Course> courseBasket = student.getCourseBasket();
        if (student.getCompletedCredit() < 165) {
            Course course = null;
            for (Course src : courseBasket) {
                if (src.getCourseId().equals("CSE4197")) {
                    course = src;
                    break;
                }
            }
            if (course != null) {
                courseBasket.remove(course);
                Error projectError = new ProjectError(student, course);
                student.addNonTakenCourse(course);
                student.addError(projectError);
            }
        }
    }


    public void MinCreditCheck(Student student) {
        List<Course> courseBasket = student.getCourseBasket();
        for (int i = 0; i < courseBasket.size(); i++) {
            Course course = courseBasket.get(i);
            if (course instanceof TechnicalElective && student.getCompletedCredit() < ((TechnicalElective) course).getMinimumCredit()) {
                Error uncompletedCreditError = new UncompletedCreditError(student, course);
                student.addNonTakenCourse(new TechnicalElective());
                student.addError(uncompletedCreditError);
                courseBasket.remove(i);
                i--;
            }
        }
    }

    public Course selectNonTakenCourse(Course course){// check again
        if(course instanceof MandatoryCourse) {
            return course;
        }else if(course instanceof TeChecker){
            return new TeChecker();
        }else if(course instanceof FacultyTechnicalCourse){
            return new FacultyTechnicalCourse();
        }else if(course instanceof NT_UCourse){
            return new NT_UCourse();
        }
        return null;
    }






    public ApproveSelectedCourses(Student student){
        String fallOrSpring = student.getSemester().getFallOrSpring();
        int semesterID = student.getSemester().getSemesterID();
        if("Fall".equals(fallOrSpring)){
            TECheck(student);
        }
        if(!(semesterID<=7) && "Fall".equals(fallOrSpring)){
            FTECheck(student);
        }
        MinCreditCheck(student);
        graduationProjectCheck(student);
        List<Course> selectedCourses = student.getSelectedCourses();

    }









}
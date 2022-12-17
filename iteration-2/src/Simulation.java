import org.json.JSONObject;
import org.json.simple.parser.ParseException;

public class Simulation{
    private StudentController studentController = new StudentController();
    private InputReader inputReader = new InputReader();
    private AdvisorController advisorController = new AdvisorController();
    private TranscriptReader transcriptReader = new TranscriptReader();
    private CourseExpert courseExpert = new CourseExpert();
    private Map<String,Object> departmentOutput = new HashMap<>();
    private int lastStudent;
    private int firstStudent;

    public Simulation(){

    }
    public void startRegistration() {
        Map<Integer, Student> studentMap = studentController.getStudentMap();
        for (Map.Entry<Integer, Student> newMap : studentMap.entrySet()) {
            Student student = newMap.getValue();
            Registrator registrator = new Registrator(student, courseExpert);
            registrator.startRegistration();
        }
    }
    public void prepareDepartmentOutput(int firstStudent, int lastStudent) {
        departmentOutput.put("First Student", firstStudent);
        departmentOutput.put("Last Student", lastStudent);
        Map<Course, List<Integer>> errorMap = studentController.prepareErrorOutput();
        List<String> strList = new ArrayList<>();
        for (Course course : errorMap.keySet()) {
            List<Integer> tmpList = errorMap.get(course);
            for (int i = 0; i < tmpList.size(); i++) {
                int numErrors = tmpList.get(i);
                if (numErrors == 0) {
                    continue;
                }
                switch (i) {
                    case 0:
                        strList.add(numErrors + " STUDENTS COULDNT REGISTER FOR " + course.getCourseId() + " DUE TO THE COLLIISION PROBLEMS");
                        break;
                    case 1:
                        strList.add(numErrors + " STUDENTS COULDNT REGISTER FOR " + course.getCourseId() + " DUE TO THE NOT IN GRADUATION PROBLEMS");
                        break;
                    case 2:
                        strList.add(numErrors + " STUDENTS COULDNT REGISTER FOR " + course.getCourseId() + " DUE TO THE PREREQUISITE PROBLEMS");
                        break;
                    case 3:
                        strList.add(numErrors + " STUDENTS COULDNT REGISTER FOR GRADUATION PROJECT");
                        break;
                    case 4:
                        strList.add(numErrors + " STUDENTS COULDNT REGISTER FOR " + course.getCourseId() + " DUE TO THE QUOTA PROBLEMS");
                        break;
                    case 5:
                        strList.add(numErrors + " STUDENTS COULDNT REGISTER FOR " + course.getCourseId() + " DUE TO THE TWO TECHNICAL ELECTIVE PROBLEMS");
                        break;
                    case 6:
                        strList.add(numErrors + " STUDENTS COULDNT REGISTER FOR " + course.getCourseId() + " DUE TO THE UNCOMPLETED CREDIT PROBLEMS");
                        break;
                }
            }
            departmentOutput.put("Errors", strList);
        }

        try {
            FileWriter outputFile = new FileWriter("DepartmentOutput.json");
            JSONObject obj = new JSONObject(departmentOutput);
            outputFile.write(obj.toString(4));
            outputFile.close();
        }
        catch (IOException e) {
        }
    }
    public void readDepartmentOutput() {
        try (InputReader inputReader = new InputReader()) {
            setLastStudent(Integer.parseInt(inputReader.readLastStudent()));
            setFirstStudent(Integer.parseInt(inputReader.readFirstStudent()));
        }
        catch (IOException e) {
        }
    }
    public void assignNextSemester() {
        Map<Integer, Student> studentMap = studentController.getStudentMap();
        for (Student student : studentMap.values()) {
            Semester currentSemester = student.getSemester();
            int nextSemesterID = currentSemester.getSemesterId() + 1;
            Semester nextSemester = courseExpert.getSemesterMap().get(nextSemesterID);
            Registrator registrator = new Registrator();
            registrator.assignNextSemester(student, nextSemester);
        }
        courseExpert.clearCourses();
    }
    public StudentController getStudentController() {
        return studentController;
    }

    public void setStudentController(StudentController studentController) {
        this.studentController = studentController;
    }

    public InputReader getInputReader() {
        return inputReader;
    }

    public void setInputReader(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public AdvisorController getAdvisorController() {
        return advisorController;
    }

    public void setAdvisorController(AdvisorController advisorController) {
        this.advisorController = advisorController;
    }

    public CourseExpert getCourseExpert() {
        return courseExpert;
    }

    public void setCourseExpert(CourseExpert courseExpert) {
        this.courseExpert = courseExpert;
    }
    public void addAllCoursesTogether() {
        List<Course> courses = new ArrayList<>();
        List<Course> mandatoryCourses = courseExpert.getMandatoryCourses();
        List<Course> technicalCourses = courseExpert.getTechnicalList();
        List<Course> facultyTechnicalCourses = courseExpert.getFacultyTechnicalList();
        List<Course> NT_UCourses = courseExpert.getNT_UList();
        for (Course course : mandatoryCourses) {
            courses.add(course);
        }
        for (Course course : technicalCourses) {
            courses.add(course);
        }
        for (Course course : facultyTechnicalCourses) {
            courses.add(course);
        }
        for (Course course : NT_UCourses) {
            courses.add(course);
        }
        courseExpert.setCourses(courses);
    }
    public void simulateSemester() {
        String[] tasks = {"startRegistration", "startGrading", "assignNextSemester"};
        for (String task : tasks) {
            switch (task) {
                case "startRegistration":
                    startRegistration();
                    break;
                case "startGrading":
                    startGrading();
                    break;
                case "assignNextSemester":
                    assignNextSemester();
                    break;
            }
        }
    }
    public int getLastStudent() {
        return lastStudent;
    }

    public Simulation setLastStudent(int lastStudent) {
        this.lastStudent = lastStudent;
        return this;
    }

    public int getFirstStudent() {
        return firstStudent;
    }

    public Simulation setFirstStudent(int firstStudent) {
        this.firstStudent = firstStudent;
        return this;
    }
    public void initializeStudents(String generation, String season){
        int firstStudent;
        int lastStudent;
        if (generation.equals("1")){

            firstStudent = 999;
            lastStudent = 999;
            setLastStudent(lastStudent);
            setFirstStudent(firstStudent);


            int lastSemester;
            if(season.equalsIgnoreCase("Fall")){

                lastSemester = 7;
            }
            else if (season.equalsIgnoreCase("Spring")){
                lastSemester = 8;
            }
            else{
                System.out.println("Error ocurred while initialization");
                lastSemester = 0;
            }

            for (int i = 1; i < lastSemester; i++) {
                if (i % 2 == 1) {
                    int superLast = getLastStudent();
                    lastStudent = inputReader.readStudentJson(superLast, studentController, courseExpert.getSemesterMap().get(1));
                    setLastStudent(lastStudent);
                }
                simulateSemester();
            }
            if(season.equalsIgnoreCase("Fall")){
                int superLast = getLastStudent();
                int ls = inputReader.readStudentJson(superLast, studentController, courseExpert.getSemesterMap().get(1));
                setLastStudent(ls);
            }

        }else {

            readDepartmentOutput();
            transcriptReader.readTranscriptJson(studentController, courseExpert, advisorController);
            if(season.equalsIgnoreCase("Fall")){
                int superLast = getLastStudent();
                int ls = inputReader.readStudentJson(superLast, studentController, courseExpert.getSemesterMap().get(1));
                setLastStudent(ls);
            }

        }

    }
    public void start() {

        checkTranscriptFolder();
        inputReader.readInstructorJson(advisorController);
        inputReader.readCourseJson(courseExpert, advisorController);
        addAllCoursesTogether();
        inputReader.readPrerequisiteJson(courseExpert);
        studentController.setInstructors(new ArrayList<>(advisorController.getInstructorMap().values()));

        String season = inputReader.readSeasonParameter();
        String generation = inputReader.readGenerationParameter();

        initializeStudents(generation,season);

        simulateSemester();
        studentController.prepareErrorOutput();
        TranscriptWriter transcriptWriter = new TranscriptWriter(studentController);
        transcriptWriter.startWriter();
        prepareDepartmentOutput(firstStudent,lastStudent);

    }
}
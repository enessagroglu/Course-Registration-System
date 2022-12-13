
public class StudentController {

    private Map<Integer, Student> HMstudent = new HashMap<>();//attribute studentMap as HashMap
    private List<Advisor> advisors;

    private Student getStudent(int id, String name, String surname, List<String> emails, Semester semester) {
        Student student = new Student(id, name, surname, emails, semester);
        return student;
    }

    public Map<Integer, Student> getHMstudent() {
        return HMstudent;
    }

    public void setHMstudent(Map<Integer, Student> studentMap) {
        this.HMstudent = HMstudent;
    }

    public List<Advisor> getAdvisors() {
        return advisors;
    }

    public void setAdvisors(List<Advisor> advisors) {
        this.advisors = advisors;
    }

    public void createStudent(int id, String name, String surname, List<String> emails, Semester semester) {
        //the function creates the student with given parameters such as id, name, surname, emails and semester
        Random random = new Random();
        Student student = getStudent(id, name, surname, emails, semester);
        List<Advisor> advisors = getAdvisors();
        int index = random.nextInt(advisors.size());
        Advisor advisor = advisors.get(index);
        student.setAdvisor(advisor);
        advisor.addStudent(student);
        Map<Integer, Student> HMstudent = getHMstudent();
        HMstudent.put(Integer.valueOf(id), student);
        student.setTranscript(new Transcript(student));
    }


    public void printStudents() {
        // Method to print all the Student objects in the HMstudent map
        Map<Integer, Student> HMstudent = this.HMstudent;
        // Obtain an iterator for the HMstudent map
        Iterator<Map.Entry<Integer, Student>> studentIterator = HMstudent.entrySet().iterator();
        // Iterate over the HMstudent map using the iterator
        while (studentIterator.hasNext()) {
            // Get the current entry in the map
            Map.Entry<Integer, Student> tempMap = (Map.Entry<Integer, Student>) studentIterator.next();
            // Print the student's ID and the Student object
            System.out.println(tempMap.getKey() + " = " + tempMap.getValue());
        }
    }


}
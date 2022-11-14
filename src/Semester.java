public class Semester {
    private SemesterName semesterName;
    private int semesterNo;

    public SemesterName getSemesterName() {
        return semesterName;
    }

    public int getSemesterNo() {
        return semesterNo;
    }
    public boolean equals(Semester obj) {
        return semesterNo == obj.semesterNo;
    }

    private void setSemesterName() {
        return;
    }

    public int compareTo(Semester obj) {
        return 1;
    }

    public String toString() {
        return "";
    }
}


import java.util.Random;

public class Semester {
    private String semesterName;
    private int semesterNo;

    public String getSemesterName() {
        return defineSemesterName(getSemesterNo());
    }

    public int getSemesterNo() {
        return semesterNoGenerate();
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
    public int semesterNoGenerate(){
        Random random=new Random();
        return random.nextInt(8-1)+1;
    }
    public String defineSemesterName(int semesterNo){
        if(semesterNo%2 == 0)
            semesterName = "SPRING";
        else
            semesterName = "FALL";
        return semesterName;

    }
}


import java.util.Random;

public class Semester {
    public static int semesterNo;
    private String semesterName;

    public String getSemesterName() {
        return defineSemesterName(getSemesterNo());
    }

    public int getSemesterNo() {
        return semesterNoGenerate();
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
    public static int semesterNoGenerate(){
        Random random=new Random();
        semesterNo=random.nextInt(8-1)+1;
        return semesterNo;
    }
    public String defineSemesterName(int semesterNo){
        if(semesterNo%2 == 0)
            semesterName = "SPRING";
        else
            semesterName = "FALL";
        return semesterName;

    }
}
public enum CourseType {
    NTE("NTE"),
    UE("UE"),
    TE("TE"),
    FTE("FTE"),
    LAB("LAB"),
    MANDATORY("Mandatory");
    private String name;

    CourseType(String name) {
        this.name = name;
    }
    public String toString(){
        return name;
    }
    public CourseType getCourseType(String type){
        switch(type) {
            case "NTE":
                return CourseType.NTE;
            case "UE":
                return CourseType.UE;
            case "TE":
                return CourseType.TE;
            case "LAB":
                return CourseType.LAB;
            case "FTE":
                return CourseType.FTE;
            default:
                return CourseType.MANDATORY;
        }
    }
}

public class Schedule implements Comparable<Schedule>{
    //The Comparable interface is a built-in Java interface that defines a single method called compareTo,
    // which allows objects of the implementing class to be compared to one another.
    private String day;//day attribute for days in schedule
    private int startTime;//startTime attribute shows the start time in schedule
    private int endTime;//endTime attribute shows the start time in schedule

    public Schedule(String day, String start, String end) {
        this.day = day;
        //start time and end time are extracted from the start and end parameters by using the split method of the
        // String class to split the strings at the : character. This creates two arrays of strings, startParsed and
        // endParsed, which contain the hour and minute parts of the start time and end time
        String [] startParsed = start.split(":");
        String [] endParsed = end.split(":");
        this.startTime = Integer.parseInt(startParsed[0] + startParsed[1]);
        this.endTime = Integer.parseInt(endParsed[0] + endParsed[1]);
        //Finally, the startTime and endTime member variables are initialized by converting the hour and minute
        // parts of the start and end times to integers and concatenating them using the + operator. The parseInt
        // method of the Integer class is used to convert the strings to integers.
        //For example, if start is "8:30" and end is "10:15", startParsed would be ["8", "30"] and endParsed
        // would be ["10", "15"]. The startTime member variable would be initialized to 830 and the endTime member
        // variable would be initialized to 1015
    }


    public String getDay() {return day;}

    public Schedule setDay(String day) {
        this.day = day;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;

        Schedule schedule = (Schedule) o;

        if (startTime != schedule.startTime) return false;
        if (endTime != schedule.endTime) return false;
        return getDay().equals(schedule.getDay());
    }

    @Override
    public int hashCode() {
        // Initialize the result variable with the hash code of the day string
        int result = getDay().hashCode();
        // Multiply the result by 31 and add the start time to it
        //use of the number 31 as a multiplier is a common technique in hash code implementations
        result = 31 * result + startTime;
        // Multiply the result by 31 and add the end time to it
        result = 31 * result + endTime;
        // Return the final result
        return result;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "day='" + day + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public int compareTo(@NotNull Schedule o) {
        //The @NotNull annotation is used to indicate that the o parameter must not be null
        // If the days of the two schedules are the same
        if (this.day.equals(o.getDay())) {
            // If the start or end time of the other schedule falls within the start and end time of this schedule
            if((o.startTime < this.endTime && o.startTime >= this.startTime) || (o.endTime <= this.endTime && o.endTime > this.startTime)){
                // Return 1 to indicate that the schedules conflict
                return 1;
            }else if(o.startTime < this.startTime && o.endTime > this.endTime){
                // Return 1 to indicate that the schedules conflict
                return 1;
            }
        }
        // If the days are different or the schedules do not conflict, return 0
        return 0;
    }
}

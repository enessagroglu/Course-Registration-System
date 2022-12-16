import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class inputCreator {


    public inputCreator() {

        JSONParser namesP = new JSONParser();
        JSONParser courseP = new JSONParser();
        ArrayList<Object> AllCourses = new ArrayList<>();

        try {

            JSONObject inputC = (JSONObject) courseP.parse(new FileReader("iteration-2/src/courses.json"));
            JSONObject inputN = (JSONObject) namesP.parse(new FileReader("iteration-2/src/names.json"));
            int quota = 10;
            int counter = 0;

            //System.out.println(AllCourses);
            // parse the JSON data and convert it to a JSONObject
            //get all names from names.json
            JSONObject output = new JSONObject(); // get input file using output name. this jsonobject uses names.json and courses.json and create input.json.


            // get the array of names from the JSONObject
            JSONArray names = (JSONArray) inputN.get("names");
            JSONArray inputCourses = (JSONArray) inputC.get("courses");

            System.out.println(AllCourses);
            // loop through the array of names

            File file = new File("input.json");
            file.delete();

            FileWriter writer1 = new FileWriter("input.json", true);
            writer1.write("{\n" + '"' +"AllStudents" + '"' + ":[\n");
            writer1.flush();

            for (Object name : names) {
                JSONArray passedcoursesarray = new JSONArray();
                JSONArray failedcoursearray = new JSONArray();
                JSONArray PassedCoursesPrereq = new JSONArray();
                if (output.get("Name") != name) {
                    int totalgivenCredits = 0;
                    output.put("Name", name);
                    // give student name. because every human being has name.

                    // Then add the "CurrentSemester" and "PassedCoursesCode" elements
                    output.put("CurrentSemester", 1 + (int) +(Math.random() * 8)); // give student random currentsemester.
                    int currentSemester = 0;
                    for (Object c : inputCourses) {
                        double randomNumber = Math.random(); // for chance

                        int result = 0;
                        currentSemester = (int) output.get("CurrentSemester");
                        double chance = currentSemester * 0.01;

                        //öğrencinin ders geçme şansını dönemine göre %10 arttır.
                        if (randomNumber < 0.5 - chance) {
                            result = 0;
                        } else {
                            result = 1;
                        }
                        int grade = 0;
                        String lettergrade;
                        JSONObject course = (JSONObject) c;
                        String courseCode = (String) course.get("CourseCode");
                        String courseName = (String) course.get("CourseName");
                        String preRequisite = course.get("PrerequisiteCourseCodes").toString().replaceAll("[^a-zA-Z0-9]", "");
                        int courseSemester = Integer.parseInt(course.get("courseSemester").toString());
                        int credits = Integer.parseInt(course.get("Credit").toString());

                        if ((int) output.get("CurrentSemester") > courseSemester) {
                            if (result == 1) {
                                totalgivenCredits += credits;
                                if (!preRequisite.equals("")) {
                                    PassedCoursesPrereq.add(preRequisite);
                                    for (int i = 0; i < passedcoursesarray.size(); i++) {
                                        if (preRequisite.equals(passedcoursesarray.get(i))) {
                                            passedcoursesarray.add(courseCode);
                                            grade = (int) ((Math.random() * (100 - 50)) + 50);
                                            passedcoursesarray.add("Grade: " + grade);
                                        }
                                    }
                                } else {
                                    passedcoursesarray.add(courseCode);
                                    grade = (int) ((Math.random() * (100 - 50)) + 50);
                                    passedcoursesarray.add("Grade: " + grade);
                                    switch (grade / 10) {
                                        case 10:
                                            lettergrade = "A+";
                                            break;
                                        case 9:
                                            lettergrade = "A";
                                            break;
                                        case 8:
                                            lettergrade = "A-";
                                            break;
                                        case 7:
                                            lettergrade = "B";
                                            break;
                                        case 6:
                                            lettergrade = "C";
                                            break;
                                        case 5:
                                            lettergrade = "D";
                                            break;
                                        default:
                                            lettergrade = "Invalid grade!";
                                            break;
                                    }
                                    passedcoursesarray.add("LetterGrade: " + lettergrade);
                                }
                            } else {
                                failedcoursearray.add(courseCode);
                                grade = (int) ((Math.random() * (50)) + 0);
                                failedcoursearray.add(grade);
                                switch (grade / 10) {
                                    case 4:
                                        lettergrade = "FF";
                                        break;
                                    case 3:
                                        lettergrade = "FF";
                                        break;
                                    case 2:
                                        lettergrade = "FF";
                                        break;
                                    case 1:
                                        lettergrade = "FF";
                                        break;
                                    default:
                                        lettergrade = "FF";
                                        break;
                                }
                                failedcoursearray.add("LetterGrade: " + lettergrade);
                            }
                        }
                        output.put("PassedCoursesCode", passedcoursesarray);
                        output.put("FailedCoursesCode", failedcoursearray);
                        output.put("preRequisite", PassedCoursesPrereq);
                        output.put("TotalGivenCredits", totalgivenCredits);
                    }


                    int randomNumber2 = (int) (Math.random() * 2); // for entryYear
                    int randomNumber3 = 100 + (int) (Math.random() * 900); // for student id
                    double v = currentSemester / 2.0;
                    int entryYear = (int) (2022 - Math.ceil(v) - randomNumber2);
                    String studentID = "1501" + (int) (entryYear - 2000) + (randomNumber3);

                    String studentmail = output.get("Name").toString().toLowerCase().replace(" ", "") + entryYear + "@marun.edu.tr";
                    output.put("entryYear", (int) entryYear);
                    output.put("studentID", studentID);
                    output.put("studentMail", studentmail);
                    JSONObject jsonObject = new JSONObject();
                    System.out.println(output); // just checkin.
                    try (FileWriter writer = new FileWriter("input.json", true)) {
                        counter++;
                        if (counter != 999) {
                            writer.write(output.toJSONString() + ",\n");
                        } else {
                            writer.write(output.toJSONString() + "\n");

                        }


                        writer.flush();
                    } catch (IOException e) {
                        System.out.println("Error writing to file: " + e.getMessage());
                    }

                    // Reset the output object to an empty object
                    output = new JSONObject();
                }
            }
            FileWriter writer2 = new FileWriter("input.json", true);
            writer2.write("]}");

            writer2.flush();
            System.out.printf("Created %d student.", counter);
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Error parsing JSON file: " + e.getMessage());
        }
    };

}

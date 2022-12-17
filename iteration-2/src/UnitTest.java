import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UnitTest {


    class InputCreatorTest {
        private static JSONObject inputN;
        private static JSONObject inputC;
        private static inputCreator creator;

        @BeforeAll
        static void setup() throws IOException, ParseException {
            // Parse the names.json and courses.json files
            JSONParser namesP = new JSONParser();
            JSONParser courseP = new JSONParser();
            inputN = (JSONObject) namesP.parse(new FileReader("iteration-2/src/names.json"));
            inputC = (JSONObject) courseP.parse(new FileReader("iteration-2/src/courses.json"));
            creator = new inputCreator();
        }

        @Test
        void testGeneratedFileExists() {
            File file = new File("input.json");
            assertTrue(file.exists());
        }

        @Test
        void testAllStudentsArrayExists() throws IOException, ParseException {
            // Parse the input.json file
            JSONParser parser = new JSONParser();
            JSONObject input = (JSONObject) parser.parse(new FileReader("input.json"));
            // Get the AllStudents array from the input object
            JSONArray allStudents = (JSONArray) input.get("AllStudents");
            assertTrue(allStudents != null);
        }

        @Test
        void testAllStudentsArrayContainsStudents() throws IOException, ParseException {
            // Parse the input.json file
            JSONParser parser = new JSONParser();
            JSONObject input = (JSONObject) parser.parse(new FileReader("input.json"));
            // Get the AllStudents array from the input object
            JSONArray allStudents = (JSONArray) input.get("AllStudents");
            assertTrue(allStudents.size() > 0);
        }

        @Test
        void testStudentsHaveCurrentSemester() throws IOException, ParseException {
            // Parse the input.json file
            JSONParser parser = new JSONParser();
            JSONObject input = (JSONObject) parser.parse(new FileReader("input.json"));
            // Get the AllStudents array from the input object
            JSONArray allStudents = (JSONArray) input.get("AllStudents");
            // Loop through the array of students
            for (Object studentObj : allStudents) {
                JSONObject student = (JSONObject) studentObj;
                // Check that each student has a CurrentSemester field
                assertTrue(student.get("CurrentSemester") != null);
            }
        }

        @Test
        void testStudentsHavePassedCourses() throws IOException, ParseException {
            JSONParser parser = new JSONParser();
            JSONObject input = (JSONObject) parser.parse(new FileReader("input.json"));
            // Get the AllStudents array from the input object
            JSONArray allStudents = (JSONArray) input.get("AllStudents");
            for (Object studentObj : allStudents) {
                JSONObject student = (JSONObject) studentObj;
                // Check that each student has a PassedCoursesArray field
                assertTrue(student.get("passedcoursesarray") != null);
            }
        }

        @Test
        void testStudentsHaveFailedCourses() throws IOException, ParseException {
            JSONParser parser = new JSONParser();
            JSONObject input = (JSONObject) parser.parse(new FileReader("input.json"));
            // Get the AllStudents array from the input object
            JSONArray allStudents = (JSONArray) input.get("AllStudents");
            for (Object studentObj : allStudents) {
                JSONObject student = (JSONObject) studentObj;
                // Check that each student has a FailedCoursesArray field
                assertTrue(student.get("failedcoursesarray") != null);
            }
        }

    }
}

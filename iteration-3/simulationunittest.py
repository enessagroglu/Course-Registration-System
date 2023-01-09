import unittest

class TestSimulation(unittest.TestCase):
    def test_showActiveCourses(self):
        student = Student(...)
        student.activeCourses = [Course(...), Course(...)]


        result = showActiveCourses(student)


        self.assertEqual(result, "Active Courses: [1] Course Code 1 Course Name 1\n[2] Course Code 2 Course Name 2")

    def test_showPassedCourses(self):

        student = Student(...)
        student.transcript.passedCourses = [Course(...), Course(...)]


        result = showPassedCourses(student)


        self.assertEqual(result, "Past Courses: [1] Course Code 1 Course Name 1\n[2] Course Code 2 Course Name 2")

    def test_showSelectedCourses(self):

        student = Student(...)
        student.selectedCourses = [Course(...), Course(...)]


        result = showSelectedCourses(student)


        self.assertEqual(result, "Selected Courses: [Course ID:1] Course Code 1 Course Name 1\n[Course ID:2] Course Code 2 Course Name 2")

    def test_showSchedule(self):

        student = Student(...)
        student.selectedCourses = [Course(schedule="Mon 9:00-11:00"), Course(schedule="Wed 13:00-15:00")]
        student.activeCourses = [Course(schedule="Tue 9:00-11:00"), Course(schedule="Fri 13:00-15:00")]


        result = showSchedule(student)


        self.assertEqual(result, "Selected: [Course ID:1] Mon 9:00-11:00\nSelected: [Course ID:2] Wed 13:00-15:00\nActive: [Course ID:3] Tue 9:00-11:00\nActive: [Course ID:4] Fri 13:00-15:00")

    def test_showFailedCourses(self):

        student = Student(...)
        student.transcript.failedCourses = [Course(...), Course(...)]


        result = showFailedCourses(student)


        self.assertEqual(result, "Failed Courses: [1] Course Code 1 Course Name 1\n[2] Course Code 2 Course Name 2")

    def test_showTranscript(self):

        student = Student(...)
        student.transcript.totalCredits = 120
        student.transcript.gpa = 3.5
        student.semester.semesterName = "Fall"
        student.semester.semesterNo = 2020
        student.transcript.grades = {"Course Code 1": "A", "Course Code 2": "B"}


        result = showTranscript(student)


        self.assertEqual(result, "Transcript info\nTotal given Credits: 120\nGPA: 3.5\nSemester: Fall - 2020\nGrades: {'Course Code 1': 'A', 'Course Code 2': 'B'}")

    def test_createSemesterCourse(self):

        student = Student(...)
        student.semester.semesterName = "Spring"
        courses = [Course(semesterName="Spring"), Course(semesterName="Fall"), Course(semesterName="Spring")]
        expected_output = [Course(semesterName="Spring"), Course(semesterName="Spring")]


        createSemesterCourse(student)
        result = semesterCourses


        self.assertEqual(result, expected_output)

    def test_printSemesterCourse(self):

        student = Student(...)
        student.transcript.failedCourses = [Course(...), Course(...)]
        semesterCourses = [Course(...), Course(...)]
        expected_output = "Course ID: [Course ID 1] Course Name: Course Code 1 Course Name 1\nCourse ID: [Course ID 2] Course Name: Course Code 2 Course Name 2\nCourse ID: [Course ID 3] Course Name: Course Code 3 Course Name 3\nCourse ID: [Course ID 4] Course Name: Course Code 4 Course Name 4"


        result = printSemesterCourse(student)


        self.assertEqual(result, expected_output)

    def test_registrationProcess(self):

        student = Student(...)
        student.semester.semesterName = "Spring"
        student.semester.semesterNo = 8
        student.transcript.totalCredits = 120
        student.transcript.failedCourses = [Course(...), Course(...)]
        student.selectedCourses = [Course(...), Course(...)]
        courses = [Course(semesterName="Spring"), Course(semesterName="Fall"), Course(semesterName="Spring")]
        expected_output = "Invalid input"


        result = registrationProcess(student)


        self.assertEqual(result, expected_output)
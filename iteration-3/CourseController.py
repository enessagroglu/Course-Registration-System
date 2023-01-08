import json
from Course import Course
from FacultyTechnicalCourse import FacultyTechnicalCourse
from MandatoryCourse import MandatoryCourse
from NTE_Course import NTE_Course
from TechnicalCourse import TechnicalCourse
from ElectiveCourse import ElectiveCourse
from Semester import Semester
from CourseSession import CourseSession

class CourseController:
    def __init__(self):
        print("**courseController Created**\n")
        

    def createCourse(self):
        # Load the JSON data from the file
        with open('courses.json', 'r') as f:
            data = json.load(f)

        # Create a list to store the Course objects
        courses = []
        
        count = 1
        # Iterate over the list of courses in the JSON data
        for course_data in data['courses']:
            course_schedule = []
            course_schedule2 = []
        # Extract the values for the attributes of the Course object
            course_id = str(count)
            name = course_data['CourseName']
            course_code = course_data['CourseCode']
            required_credits = course_data['requiredCredits']
            semester_number = course_data['courseSemester']
            course_type = course_data['courseType']
            course_current_student_number = course_data['courseCurrentStudentNumber']
            quota = 100
            sessions = ""
            credit = course_data['Credit']
            session_count = course_data['courseSessions']
            prerequisites = course_data['PrerequisiteCourseCodes']

            if "schedule" in course_data:
                for course_schedule_data in course_data["schedule"]:
                    course_schedule.append(course_schedule_data)

            if "schedule2" in course_data:
                for course_schedule_data in course_data["schedule2"]:
                    course_schedule2.append(course_schedule_data)

            if session_count > 1:
                course_sessions = []
                count = 2
                for i in range(session_count):
                    course_session = CourseSession(count,course_schedule2)
                    course_sessions.append(course_session)
                    count+=1

                sessions = course_sessions
            
            

            semesterclass = Semester(semester_number,self.getPeriod(semester_number))
            
            # Create a new Course object with the extracted values
            if course_type == "Mandatory":
                course = MandatoryCourse(course_id, name, course_code, required_credits, semester_number, course_type, course_current_student_number, semesterclass, quota, credit, session_count, sessions, prerequisites,course_schedule)
            elif course_type == "NTExxx":
                course = NTE_Course(course_id, name, course_code, required_credits, semester_number, course_type, course_current_student_number, semesterclass, quota, credit, session_count, sessions, prerequisites,course_schedule)
            elif course_type == "TExxx":
                course = TechnicalCourse(course_id, name, course_code, required_credits, semester_number, course_type, course_current_student_number, semesterclass, quota, credit, session_count, sessions, prerequisites,course_schedule)
            elif course_type == "FTExxx":
                course = FacultyTechnicalCourse(course_id, name, course_code, required_credits, semester_number, course_type, course_current_student_number, semesterclass, quota, credit, session_count, sessions, prerequisites,course_schedule)
            elif course_type == "Elective":
                course = ElectiveCourse(course_id, name, course_code, required_credits, semester_number, course_type, course_current_student_number, semesterclass, quota, credit, session_count, sessions, prerequisites,course_schedule)
            else:
                course = Course(course_id, name, course_code, required_credits, semester_number, course_type, course_current_student_number, semesterclass, quota, credit, session_count, sessions, prerequisites,course_schedule)
    
            # Add the Course object to the list
            courses.append(course)
            count += 1
        return courses

    def printCourses(self, courses):
    # Print the list of Course objects
        print("**Created Courses:")
        for course in courses:
            print(course)
            print("")

    def getPeriod(self,semesterNo):
        if (semesterNo % 2) == 0:
            return "Spring"
        else:
            return "Fall"

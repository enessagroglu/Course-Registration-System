import json
from Course import Course
from FacultyTechnicalCourse import FacultyTechnicalCourse
from MandatoryCourse import MandatoryCourse
from NTE_Course import NTE_Course
from TechnicalCourse import TechnicalCourse
from ElectiveCourse import ElectiveCourse


class CourseController:
    def __init__(self):
        print("**courseController Created**\n")
        

    def createCourse(self):
        # Load the JSON data from the file
        with open('Courses.json', 'r') as f:
            data = json.load(f)

        # Create a list to store the Course objects
        courses = []
        count = 1
        # Iterate over the list of courses in the JSON data
        for course_data in data['courses']:
        # Extract the values for the attributes of the Course object
            course_id = count
            name = course_data['CourseName']
            course_code = course_data['CourseCode']
            required_credits = course_data['requiredCredits']
            semester_number = course_data['courseSemester']
            course_type = course_data['courseType']
            course_current_student_number = course_data['courseCurrentStudentNumber']
            semester = ""
            quota = 100
            credit = course_data['Credit']
            session_count = course_data['courseSessions']
            sessions = ""
            prerequisites = course_data['PrerequisiteCourseCodes']
            
    
            # Create a new Course object with the extracted values
            if course_type == "Mandatory":
                course = MandatoryCourse(course_id, name, course_code, required_credits, semester_number, course_type, course_current_student_number, semester, quota, credit, session_count, sessions, prerequisites)
            elif course_type == "NTE":
                course = NTE_Course(course_id, name, course_code, required_credits, semester_number, course_type, course_current_student_number, semester, quota, credit, session_count, sessions, prerequisites)
            elif course_type == "TE":
                course = TechnicalCourse(course_id, name, course_code, required_credits, semester_number, course_type, course_current_student_number, semester, quota, credit, session_count, sessions, prerequisites)
            elif course_type == "FTE":
                course = FacultyTechnicalCourse(course_id, name, course_code, required_credits, semester_number, course_type, course_current_student_number, semester, quota, credit, session_count, sessions, prerequisites)
            elif course_type == "Elective":
                course = ElectiveCourse(course_id, name, course_code, required_credits, semester_number, course_type, course_current_student_number, semester, quota, credit, session_count, sessions, prerequisites)
            else:
                course = Course(course_id, name, course_code, required_credits, semester_number, course_type, course_current_student_number, semester, quota, credit, session_count, sessions, prerequisites)
    
            # Add the Course object to the list
            courses.append(course)
            count += 1
        return courses

    def printCourses(self, courses):
    # Print the list of Course objects
        print("**Created Courses:")
        for course in courses:
            #if type(course) == 'TechnicalCourse':
            print(course)
            print("")
from CourseController import *
from StudentController import *
from AdvisorController import *

class RegisterSystem:
    
    courseController = CourseController()
    studentController = StudentController()
    advisorController = AdvisorController()

    courses = courseController.createCourse()
    students = studentController.createStudent()
    advisors = advisorController.createAdvisor()

    #courseController.printCourses(courses)

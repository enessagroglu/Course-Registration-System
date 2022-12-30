from CourseController import *

def main():
    courseController = CourseController()
    courses = []
    courses = courseController.createCourse()


    courseController.printCourses(courses)

main()

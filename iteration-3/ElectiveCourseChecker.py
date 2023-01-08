from Checker import Checker
from Course import Course
from Student import Student

class ElectiveCourseChecker(Checker):  
    def __init__(self, student, course):
        super().__init__(student)
        self.course = course

    def get_course(self):
        return self.course

    def set_course(self, course):
        self.course = course

    def raise_course(self):
        return self.course

def electiveCourseCheck(student: Student, course: Course) -> bool:
    past_courses = student._transcript.passedCourses
    selected_courses = student.selectedCourses()

    if course in past_courses:
        return False
    elif course in selected_courses:
        print("You Already Selected this Course")
        return False
    elif course in student._activeCourses:
        print("You are already taking this Course")
        return False
    else:
        return True
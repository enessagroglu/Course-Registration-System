from Course import Course
from Student import Student
from Checker import Checker

class PrequisiteCheck(Checker):  
    def __init__(self, student, course):
        super().__init__(student)
        self.course = course

    def get_course(self):
        return self.course

    def set_course(self, course):
        self.course = course

    def raise_course(self):
        return self.course


def prequisiteCheck(student: Student, course: Course)-> bool:
    past_courses = student.pastCourses()
    prequisites = course.prequisites()
        
    for need in prequisites:
        if need not in past_courses:
            print("You need to take "+ need+" before that course.")
            return False
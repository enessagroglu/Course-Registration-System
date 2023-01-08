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
    past_courses = student._transcript.failedCourses
    past_courses.extend(student._nonTakenCourses)

    prerequisites = course._prerequisites
    count = 0
    if len(prerequisites) == 0:
        return True
    else:
        for preq in prerequisites:
            for course in past_courses:
                if preq == course._courseCode:
                    return False
                else:
                    pass
        return True
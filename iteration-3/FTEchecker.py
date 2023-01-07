from Checker import Checker
from FacultyTechnicalCourse import FacultyTechnicalCourse
from Student import Student

class FTEChecker(Checker):  
    def __init__(self, student, course):
        super().__init__(student)
        self.course = course

    def get_course(self):
        return self.course

    def set_course(self, course):
        self.course = course

    def raise_course(self):
        return self.course

def FTEcheck(student: Student):
    selectedCourses = student.selectedCourses()
    course = None
    for temp in selectedCourses:
        if isinstance(temp, FacultyTechnicalCourse):
            course = temp
            break

        if course is not None:
            selectedCourses.remove(course)
            print("Student is not in graduate year.")
            student.selectedCourses = selectedCourses
            student.addNonTakenCourse(course)
from Checker import Checker
from Student import Student
from TechnicalCourse import TechnicalCourse

class TeElectiveChecker(Checker):
    def __init__(self, student, course):
        super().__init__(student)
        self.course = course

    def get_course(self):
        return self.course

    def set_course(self, course):
        self.course = course

    def raise_course(self):
        return self.course

def TEcheck(student: Student):
    selectedCourseList = student.selectedCourses()
    for i in range(len(selectedCourseList)):
        course = selectedCourseList[i]
        if isinstance(course, TechnicalCourse):
            count += 1
            if count > 2:
                
                student.addNonTakenCourse(course)
                
                selectedCourseList.remove(course)
                i -= 1
                count -= 1
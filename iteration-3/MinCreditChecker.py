from Checker import Checker
from Student import Student
from TechnicalCourse import TechnicalCourse

class MinCreditChecker(Checker):  
    def __init__(self, student, course):
        super().__init__(student)
        self.course = course

    def get_course(self):
        return self.course

    def set_course(self, course):
        self.course = course

    def raise_course(self):
        return self.course



def minCreditCheck(student: Student):
    selectedCourseList = student.selectedCourses()
    for i in range(len(selectedCourseList)):
        course = selectedCourseList[i]
        if isinstance(course, TechnicalCourse) and student.completedCredit() < course.requiredCredits():
            student.addNonTakenCourse(course)
            print("Completed Credit is not enough."+ course)
            selectedCourseList.remove(course)
            i -= 1
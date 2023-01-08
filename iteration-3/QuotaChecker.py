from Checker import Checker
from Course import Course

class QuotaChecker(Checker):  
    def __init__(self, student, course):
        super().__init__(student)
        self.course = course

    @property
    def course(self):
        return self.course

    @course.setter
    def course(self, course):
        self.course = course

    def raise_course(self):
        return self.course


def  quotaCheck(course: Course)-> bool:
    quota = course._quota
    currentNum = course._courseCurrentStudentNumber
    if quota-currentNum > 0:
        return True
    else:
        print("Quota is full")
        return False

from Checker import Checker
from Student import Student


class GraduationProjectChecker(Checker):  
    def __init__(self, student, course):
        super().__init__(student)
        self.course = course

    def get_course(self):
        return self.course

    def set_course(self, course):
        self.course = course

    def raise_course(self):
        return self.course


def graduationProjectCheck(student: Student):
    if student._transcript.totalCredits < 165:
        print("You do not have enough credits to take 'CSE4297'")
        return False
    else:
        return True
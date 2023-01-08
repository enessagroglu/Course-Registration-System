from Checker import *
from Student import *
from Course import *

class UncompletedCreditChecker(Checker):
    def init(self, student: Student, course: Course):
        super().init(student)
        self.course = course

    def get_course(self):
        return self.course

    def set_course(self, course):
        self.course = course

    def raise_course(self):
        return self.course


    def raise_error(self):
        return f"You can not take {self.course._courseCode()} because student completed credits < 155"

def checkCredit(student: Student):
    
    if student._transcript.totalCredits < 155:
        print("Your Total Credits is not enough to take TE Course.")
        return False
    else:
        return True
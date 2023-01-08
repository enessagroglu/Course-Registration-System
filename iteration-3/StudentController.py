import random
from Student import *

from Transcript import Transcript

class StudentController:
    def __init__(self):
        self.HMstudent = {}
        self.advisors = []

    def get_student(self, id, name, surname, emails, semester):
        student = Student(id, name, surname, emails, semester)
        return student

    def get_HMstudent(self):
        return self.HMstudent

    def set_HMstudent(self, student_map):
        self.HMstudent = student_map

    def get_advisors(self):
        return self.advisors

    def set_advisors(self, advisors):
        self.advisors = advisors

    def create_student(self, id, name, surname, emails, semester):
        student = self.get_student(id, name, surname, emails, semester)
        advisors = self.get_advisors()
        index = random.randint(0, len(advisors) - 1)
        advisor = advisors[index]
        student.set_advisor(advisor)
        advisor.add_student(student)
        HMstudent = self.get_HMstudent()
        HMstudent[id] = student
        student.set_transcript(Transcript(student))

    def print_students(self):
        HMstudent = self.HMstudent
        for key, value in HMstudent.items():
            print(key, "=", value)

StudentController.create_student()
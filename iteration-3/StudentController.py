from Student import Student
from Transcript import Transcript


class StudentController:
    def __init__(self):
        self.hm_student = {}  # attribute studentMap as dictionary
        self.advisors = []

    def get_student(self, id, name, surname,  semester):
        student = Student(id, name, surname,  semester)
        return student

    def get_hm_student(self):
        return self.hm_student

    def set_hm_student(self, student_map):
        self.hm_student = student_map

    def get_advisors(self):
        return self.advisors

    def set_advisors(self, advisors):
        self.advisors = advisors

    def create_student(self, id, name, surname,  semester):
        # the function creates the student with given parameters such as id, name, surname, emails and semester
        import random
        student = self.get_student(id, name, surname,  semester)
        advisors = self.get_advisors()
        index = random.randint(0, len(advisors) - 1)
        advisor = advisors[index]
        student.set_advisor(advisor)
        advisor.add_student(student)
        hm_student = self.get_hm_student()
        hm_student[id] = student
        student.set_transcript(Transcript(student))

    def print_students(self):
        # Method to print all the Student objects in the hm_student map
        hm_student = self.hm_student
        # Iterate over the hm_student map
        for id, student in hm_student.items():
            # Print the student's ID and the Student object
            print(f"{id} = {student}")



student_controller = StudentController()

a = student_controller.create_student(1, "John", "Doe",  "2")

student_controller.print_students(a)
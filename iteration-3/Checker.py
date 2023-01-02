class Checker: 
    def __init__(self, student):
        self.student = student

    def get_student(self):
        return self.student

    def set_student(self, student):
        self.student = student

    def raise_course(self):
        return None

    def raise_error(self):
        return "Abstract Error"
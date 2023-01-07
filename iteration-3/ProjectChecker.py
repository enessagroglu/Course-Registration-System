from Checker import Checker

class ProjectChecker(Checker):
    def __init__(self, student, course):
        super().__init__(student)
        self.course = course

    def get_course(self):
        return self.course

    def set_course(self, course):
        self.course = course

    def raise_course(self):
        return self.course

    def raise_error(self):
        return "The advisor disapproved  " + self.course.get_course_id() + " since the student earned credits < 165"
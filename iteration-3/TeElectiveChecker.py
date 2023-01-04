from Checker import Checker
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

    def raise_error(self):
        return f"The advisor disapproved {self.course.get_course_id()} since the student already took two TE, and only two TE can be taken during the fall semester."
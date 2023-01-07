from Checker import Checker
class QuotaError(Checker):  
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

    def raise_error(self):
        return "The student was unable to sign up for {} as a result of a quota issue.".format(self.course.course_id)
    
class UncompletedCreditChecker(Error):
    def init(self, student, course):
        super().init(student)
        self.course = course

    def get_course(self):
        return self.course

    def set_course(self, course):
        self.course = course

    def raise_course(self):
        return self.course

    def raise_error(self):
        return f"The advisor didn't approve {self.course.get_course_id()} because student completed credits < 155"
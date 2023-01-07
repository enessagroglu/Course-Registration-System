from Checker import Checker
class CollisionChecker(Checker): 
    def __init__(self, student, first_course, second_course):
        super().__init__(student)
        self.first_course = first_course
        self.second_course = second_course

    @property
    def first_course(self):
        return self.first_course

    @first_course.setter
    def first_course(self, first_course):
        self.first_course = first_course

    @property
    def second_course(self):
        return self.second_course

    @second_course.setter
    def second_course(self, second_course):
        self.second_course = second_course

    def raise_course(self):
        return self.second_course

    def raise_error(self):
        return "The advisor rejected it. {} due to the collision with {} in schedule".format(self.second_course.name, self.first_course.name)
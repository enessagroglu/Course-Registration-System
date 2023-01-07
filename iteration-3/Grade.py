class Grade(object):

    def __init__(self,course,intGrade):
        self.course = course
        self.intGrade =intGrade
        self.setLetterGradeMap()

    def hasPassed(self):
        return self.intGrade >= 50

    def setLetterGradeMap(self):
        if self.intGrade < 0 or self.intGrade > 100:
            raise ValueError("Grades must be between 0-100!")

        grades_map = {
            0: "FF",
            45: "FD",
            50: "DD",
            55: "DC",
            65: "CC",
            75: "CB",
            80: "BB",
            85: "BA",
            90: "AA"
        }

        closest_key = max(key for key in grades_map if key <= self.intGrade)
        self.letterGrade = grades_map[closest_key]
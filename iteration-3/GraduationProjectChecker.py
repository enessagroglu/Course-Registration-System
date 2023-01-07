from Checker import Checker
from Student import Student


class GraduationProjectChecker(Checker):  
    def __init__(self, student, course):
        super().__init__(student)
        self.course = course

    def get_course(self):
        return self.course

    def set_course(self, course):
        self.course = course

    def raise_course(self):
        return self.course


def graduationProjectCheck(student: Student):
    selectedCourseList = student.selectedCourses()
    if student.completedCredit() < 165:
        course = None
        for temp in selectedCourseList:
            if temp.courseCode() == "CSE4197":
                course = temp
                break
        if course is not None:
            selectedCourseList.remove(course)
            student.addNonTakenCourse(course)
            print("Project error")
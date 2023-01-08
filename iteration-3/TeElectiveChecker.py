from Checker import Checker
from Student import Student
from TechnicalCourse import TechnicalCourse
from Course import *

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

def TEcheck(student: Student):
    count = 0
    selectedCourseList = student._selectedCourses
    activeCourseList = student._activeCourses
    for i in range(len(activeCourseList)):
        courseActive = activeCourseList[i]
        if isinstance(courseActive, TechnicalCourse):
            count +=1
            if count == 3:
                print("You can not take more than 3 TE courses")
                return
            elif count > 3:
                print("TE COURSE ERROR ")
                return

    for i in range(len(selectedCourseList)):
        course = selectedCourseList[i]
        if isinstance(course, TechnicalCourse):
            count += 1
            if count > 3:
                student.addNonTakenCourse(course)
                selectedCourseList.remove(course)
                print(f"You can not select more than 2 TE courses, {course._courseCode} is removed from your list.")
                i -= 1
                count -= 1
    if count == 3:
        print("You can not take more than 2 TE courses")
        return False
    elif count < 3 and count > -1:
        return True
    else:
        print("TE COURSE ERROR 2 ")
        return False
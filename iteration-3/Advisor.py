from FTEchecker import * 
from Person import *

from QuotaChecker import *
from Student import *
from typing import List
from ElectiveCourse import *
from FacultyTechnicalCourse import *
from TechnicalCourse import *
from Semester import *

class Advisor(Person):
    def __init__(self, name: str,surname: str, id: str):
        super().__init__(name, surname,id)
        
        
        self._password = "123"
    
  

# def approve(course: Course, student: Student)->bool:
#     if isinstance(course, ElectiveCourse):
#         quotaChecked = quotaCheck(course)
#         electiveCourseChecked = electiveCourseCheck(student,course)
#     prequisiteChecked = prequisiteCheck(student, course)
#     return quotaChecked and electiveCourseChecked and prequisiteChecked


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









def ApproveSelectedCourses(student: Student):
    fallOrSpring = student.semester().get_fall_or_spring()
    semesterID = student.semester().semesterID()
    approvedCourses = []
    if fallOrSpring == "Fall":
        FTEcheck(student)
    if not (semesterID <= 7) and fallOrSpring == "Fall":
        FTEcheck(student)
    minCreditCheck(student)
    graduationProjectCheck(student)
    for i in student.selectedCourses():
        if i in student.activeCourses():
            continue
        else:
            approvedCourses.append(i)

# def ApproveSelectedCourses(student: Student):
#     fallOrSpring = student.semester().get_fall_or_spring()
#     semesterID = student.semester().semesterID()
#     approvedCourses = []
#     if fallOrSpring == "Fall":
#         TEcheck(student)
#     if not (semesterID <= 7) and fallOrSpring == "Fall":
#         FTEcheck(student)
#     minCreditCheck(student)
#     graduationProjectCheck(student)
#     for i in student.selectedCourses():
#         if i in student.activeCourses():
#             continue
#         else:
#             approvedCourses.append(i)

    
#     student.activeCourses = approvedCourses
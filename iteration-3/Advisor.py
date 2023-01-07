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
    def __init__(self, name: str,surname: str, id: str, clients: List[Student]):
        super().__init__(name, surname,id)
        
        self._clients = clients
    
    
    @property
    def clients(self):
        return self._clients
    
    @clients.setter
    def clients(self, clients: List[Student]):
        self._clients = clients
    
    def addClient(self, student: Student):
        self._clients.append(student)
     
def prequisiteCheck(student: Student, course: Course)-> bool:
    past_courses = student.pastCourses()
    prequisites = course.prequisites()
        
    for need in prequisites:
        if need not in past_courses:
            print("You need to take "+ need+" before that course.")
            return False


def approve(course: Course, student: Student)->bool:
    if isinstance(course, ElectiveCourse):
        quotaChecked = quotaCheck(course)
        electiveCourseChecked = electiveCourseCheck(student,course)
    prequisiteChecked = prequisiteCheck(student, course)
    return quotaChecked and electiveCourseChecked and prequisiteChecked

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

def minCreditCheck(student: Student):
    selectedCourseList = student.selectedCourses()
    for i in range(len(selectedCourseList)):
        course = selectedCourseList[i]
        if isinstance(course, TechnicalCourse) and student.completedCredit() < course.requiredCredits():
            student.addNonTakenCourse(course)
            print("Completed Credit is not enough."+ course)
            selectedCourseList.remove(course)
            i -= 1

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
    
    student.activeCourses = approvedCourses
from CourseController import *
from StudentController import *
from AdvisorController import *
from Student import *
from QuotaChecker import *
from TeElectiveChecker import *
from UncompletedCreditChecker import *
from PrequisiteChecker import *
from ElectiveCourseChecker import *
from GraduationProjectChecker import *
from Advisor import *

class Simulation:
    
    courseController = CourseController()
    studentController = StudentController()
    advisorController = AdvisorController()

    global courses
    global semesterCourses
    global advisors
    global students
    global temp_course

    courses = courseController.createCourse()
    advisors = advisorController.createAdvisor()
    semesterCourses = []
    students = studentController.createStudent()
    
    global mcgAdvisor
    mcgAdvisor = Advisor("Murat", "Ganiz","")
    


def studentMenu():
    menuText = """
        * Student Menu *

    [1] Show Passed Courses
    [2] Show Selected Courses
    [3] Show Active Courses
    [4] Show Schedule
    [5] Show Failed Courses
    [6] Show Transcript
    [7] Registration Process
    [8] Send selected courses for approval to advisor
    [9] Show Advisors

    [0] Log out
    """
    print(menuText)
    
def showActiveCourses(student: Student):
    print(" Active Courses: ")
    count = 1
    if len(student.activeCourses) == 0:
        print("There is no Active Course")
    else:
        for courses in student.activeCourses:
            print(f"[{count}] {courses.courseCode} {courses.name}")
            count +=1

def showPassedCourses(student: Student):
    print(" Past Courses: ")
    count = 1
    if len(student._transcript.passedCourses) == 0:
        print("There is no Past Course")
    else:
        for courses in student._transcript.passedCourses:
            print(f"[{count}] {courses.courseCode} {courses.name}")
            count +=1

def showSelectedCourses(student: Student):
    print(" Selected Courses: ")
    
    if len(student.selectedCourses) == 0:
        print("There is no Selected Course")
    else:
        for course in student._selectedCourses:
            print(f"[Course ID:{course._courseId}] {course._courseCode} {course._name}")
    operation = input("Enter an ID to drop that course(0 to exit):")
    if operation == "0":
        return
    else:
        for course in student._selectedCourses:
            if course._courseId == operation:
                student._selectedCourses.remove(course)
                showSelectedCourses(student)
        print("Invalid Course ID..")
        showSelectedCourses(student)
            

def showSchedule(student: Student):
    for course in student._selectedCourses:
        print(f"Selected: [Course ID:{course._courseId}] {course._schedule}")
    for course in student._activeCourses:
        print(f"Active: [Course ID:{course._courseId}] {course._schedule}")

def showFailedCourses(student: Student):
    print(" Failed Courses: ")
    count = 1
    if len(student.transcript.failedCourses) == 0:
        print("There is no failed Course")
    else:
        for courses in student.transcript.failedCourses:
            print(f"[{count}] {courses.courseCode} {courses.name}")
            count +=1

def showTranscript(student: Student):
    print(" Transcript info ")
    print(f""" 
    Total given Credits:{student.transcript.totalCredits}
    GPA: {student._transcript.gpa}
    Semester: {student._semester._semesterName} - {student._semester._semesterNo}
    Grades: {student._transcript.grades}
    """)

def createSemesterCourse(student: Student):
    for course in courses:
        if student._semester._semesterName == course._semester._semesterName:
            if course not in student._transcript.passedCourses:
                semesterCourses.append(course)

def printSemesterCourse(student: Student):

    for course in semesterCourses:
        if (student._semester._semesterNo >= course._semester._semesterNo):
            if course not in student._transcript.passedCourses:
                print(f"Course ID: [{course._courseId}] Course Name: {course._courseCode} {course._name}")


def registrationProcess(student1: Student):
    student = student1

    
    printSemesterCourse(student)
    selectedID = input("Enter a Course ID to select(0 for exit):")
    try:
        
        if not selectedID:
            print("invalid CourseID")
            registrationProcess(student)
        elif selectedID == "0":
            studentOptions(student)
        else:
            for course in courses:
                if selectedID == course._courseId:
                    temp_course = course
                    break
            
            if temp_course == None:
                print("Invalid Course ID")
                studentOptions(student)

            #   CHECKERS
            
            if temp_course not in student._transcript.passedCourses and temp_course not in student._selectedCourses:
                if isinstance(temp_course, MandatoryCourse):
                    
                    if prequisiteCheck(student,temp_course):
                        if temp_course._courseCode == "CSE4297":
                            if(graduationProjectCheck(student)):
                                student._selectedCourses.append(temp_course)
                                registrationProcess(student)
                            else:
                                student._selectedCourses.append(temp_course)
                                registrationProcess(student)
                        else:
                            student._selectedCourses.append(temp_course)
                            registrationProcess(student)
                    else:
                        print("PrereqError")
                        registrationProcess(student)
                else:
                    if quotaCheck(temp_course):

                        if isinstance(temp_course, TechnicalCourse):
                            if prequisiteCheck(student,temp_course):
                                semNo = int(student._semester._semesterNo)
                                if TEcheck(student) and semNo>7 and checkCredit(student):
                                    student._selectedCourses.append(temp_course)
                                    registrationProcess(student)
                                else:
                                    print("You are not allowed to take TE course")
                                    registrationProcess(student)
                            else:
                                print("PrereqError")
                                registrationProcess(student)
                        elif isinstance(temp_course,NTE_Course):
                            if electiveCourseCheck(student, temp_course):
                                student._selectedCourses.append(temp_course)
                                registrationProcess(student)
                            else:
                                print(f"You can not allowed to take this course:{temp_course._courseCode} ")
                                registrationProcess(student)
                        elif isinstance(temp_course, FacultyTechnicalCourse):
                            if prequisiteCheck(student,temp_course):
                                semNo = int(student._semester._semesterNo)
                                if TEcheck(student) and semNo>7 and checkCredit(student):
                                    student._selectedCourses.append(temp_course)
                                    registrationProcess(student)
                                else:
                                    print("You are not allowed to take FTE course")
                                    registrationProcess(student)
                            else:
                                print("PrereqError")
                                registrationProcess(student)
                    else:
                        print("Quota problem.")
                        registrationProcess(student)
            else:
                print("This Course is Already Taken.")
                registrationProcess(student)

    except ValueError as ve:
        print(ve)
        registrationProcess(student)


def login():
    
    print("* Please Login *")
    username = input("Username:")
    password = input("Password:")
    
    try:
        username = username.strip()
        password = password.strip()
        if not username or not password:
            print("invalid username or password")
            login()
        
        else:
            for temp_user in students:
                if temp_user._username == username and temp_user._password == password:
                    user = temp_user
                    return user
            print("User not found") 
            login()
    except ValueError as ve:
        print(ve)
        login()
    


def studentOptions(student: Student):
    studentMenu()
    option = int(input("Select an operation:"))

    if option == 1:
        showPassedCourses(student)
        studentOptions(student)
    elif option == 2:
        showSelectedCourses(student)
        studentOptions(student)
    elif option == 3:
        showActiveCourses(student)
        studentOptions(student)
    elif option == 4:
        showSchedule(student)
        studentOptions(student)
    elif option == 5:
        showFailedCourses(student)
        studentOptions(student)
    elif option == 6:
        showTranscript(student)
        studentOptions(student)
    elif option == 7:
        registrationProcess(student)
        studentOptions(student)
    elif option == 8:
        mcgAdvisor.approve(student)
        studentOptions(student)
    elif option == 9:
        for advisor in advisors:
            print(f"Name:{advisor._name} Surname:{advisor._surname} Email: {advisor._email}")
        studentOptions(student)
    elif option == 0:
        semesterCourses.clear()
        simulation()

def simulation():
    try:
        
        currentUser = login()
        if type(currentUser) == Student:
            createSemesterCourse(currentUser)
            studentOptions(currentUser)
        elif type(currentUser) == Advisor:
            pass
    except TypeError as tp:
        print("An unidentified error has occurred, you are being redirected to the login page")
        login()



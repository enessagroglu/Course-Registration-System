from CourseController import *
# from StudentController import *
from AdvisorController import *
from Student import *
from QuotaChecker import *
from TeElectiveChecker import *
from UncompletedCreditChecker import *
from PrequisiteChecker import *
from ElectiveCourseChecker import *
from GraduationProjectChecker import *
from Advisor import *
import logging

# create a logger with the name of the current module
logger = logging.getLogger(__name__)

# set the logging level to DEBUG
logger.setLevel(logging.DEBUG)

# create a file handler to log messages to a file
file_handler = logging.FileHandler('app.log')

# create a logging format
import logging

logging.basicConfig(filename='app.log', filemode='w', format='%(name)s - %(levelname)s - %(message)s')
logging.warning('This will get logged to a file')

# add the file handler to the logge
# r
logger.addHandler(file_handler)

# you can now log messages using the logger object
logger.debug('This is a debug message')
logger.info('This is an info message')
logger.warning('This is a warning message')
logger.error('This is an error message')
logger.critical('This is a critical message')


class Simulation:
    
    try:
        courseController = CourseController()
        #studentController = StudentController()
        advisorController = AdvisorController()

        global courses
        global semesterCourses
        global advisors
        courses = courseController.createCourse()
        advisors = advisorController.createAdvisor()
        semesterCourses = []
        #students = studentController.createStudent()

        global mcgAdvisor
        mcgAdvisor = Advisor("Murat", "Ganiz","")
    except Exception as e:
        print("An error occurred:", e)
        logger.error(e);

try:
    student1 = Student("enes","sagiroglu","150119725","","","","","","","","","","","")
except Exception as e:
    print("An error occurred:", e)


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
    if len(student.transcript.passedCourses) == 0:
        print("There is no Past Course")
    else:
        for courses in student.transcript.passedCourses:
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
    if operation == 0:
        return
    else:
        for course in student._selectedCourses:
            if course._courseId == operation:
                student._selectedCourses.remove(course)
                showSelectedCourses(student)
        print("Invalid Course ID..")
        showSelectedCourses(student)
            

def showSchedule(student: Student):
    print(student._schedule)

def showFailedCourses(student: Student):
    print(" Failed Courses: ")
    count = 1
    try:
        if len(student.transcript.failedCourses) == 0:
            print("There is no failed Course")
        else:
            for courses in student.transcript.failedCourses:
                print(f"[{count}] {courses.courseCode} {courses.name}")
                count +=1
    except Exception as e:
        print("An error occurred:", e)
        logger.error(e)


def showTranscript(student: Student):
    print(" Transcript info ")
    try:
        print(f""" 
        Total given Credits:{student.transcript.totalCredits}
        GPA: {student._transcript.gpa}
        Semester: {student._semester}
        """)
    except Exception as e:
        print("An error occurred:", e)
        logger.error(e)

def printSemesterCourse(student: Student):
    
    for course in courses:
        if student._semester._semesterName == course._semester._semesterName:
            if course not in student._transcript.passedCourses:
                semesterCourses.append(course)
    for course in semesterCourses:
        try:
            print(f"Course ID: [{course._courseId}] Course Name: {course._name} - Credit: {course._credit} - Status: {course._status} - Instructor: {course._instructor}")
        except Exception as e:
            print("An error occurred:", e)
            logger.error(e)



def registrationProcess(student1: Student):
    student = student1

    if len(student.selectedCourses) == 0:
        
        for course in student.transcript.failedCourses:
            if course._semester._semesterName == student._semester._semesterName:
                student._selectedCourses.append(course)
    
    printSemesterCourse()
    selectedID = input("Enter a Course ID to select(0 for exit):")
    try:
        selectedID = selectedID.strip()
        if not selectedID:
            print("invalid CourseID")
            registrationProcess(student)
        elif selectedID == 0:
            studentOptions(student)
        else:
            for course in courses:
                if str(selectedID) == course._courseId:
                    temp_course = course

            #   CHECKERS
            if temp_course not in student._transcript.passedCourses:
                if isinstance(temp_course, MandatoryCourse) and prequisiteCheck(student,temp_course):
                    if temp_course._courseCode == "CSE4297":
                        if(graduationProjectCheck(student)):
                            student._selectedCourses.append(temp_course)
                            registrationProcess(student)
                        else:
                            student._selectedCourses.append(temp_course)
                            registrationProcess(student)
                else:
                    if quotaCheck(temp_course):

                        if isinstance(temp_course, TechnicalCourse) and prequisiteCheck(student,temp_course):
                            semNo = int(student._semester._semesterNo)
                            if TEcheck(student) and semNo>7 and checkCredit(student):
                                student._selectedCourses.append(temp_course)
                                registrationProcess(student)
                            else:
                                print("You are not allowed to take TE course")
                                registrationProcess(student)
                        elif isinstance(temp_course,NTE_Course):
                            if electiveCourseCheck(student, temp_course):
                                student._selectedCourses.append(temp_course)
                                registrationProcess(student)
                            else:
                                print(f"You can not allowed to take this course:{temp_course._courseCode} ")
                                registrationProcess(student)
                        elif isinstance(temp_course, FacultyTechnicalCourse) and prequisiteCheck(student,temp_course):
                            semNo = int(student._semester._semesterNo)
                            if TEcheck(student) and semNo>7 and checkCredit(student):
                                student._selectedCourses.append(temp_course)
                                registrationProcess(student)
                            else:
                                print("You are not allowed to take FTE course")
                                registrationProcess(student)
                    else:
                        print("Quota problem.")
                        registrationProcess(student)
                    
    except ValueError as ve:
        print(ve)
        registrationProcess(student)
        logger.error(e)


def login():
    students = []
    students.append(student1)

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
        logger.error(e)
    


def studentOptions(student: Student):
    studentMenu()
    option = input("Select an operation:")

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
    elif option == 0:
        login()

def simulation():
    try:
        currentUser = login()
        if type(currentUser) == Student:
            studentOptions(currentUser)
        elif type(currentUser) == Advisor:
            pass
    except TypeError as tp:
        print("An unidentified error has occurred, you are being redirected to the login page")
        login()
        logger.error(e)



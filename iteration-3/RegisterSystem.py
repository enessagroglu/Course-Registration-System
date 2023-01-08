from CourseController import *
from StudentController import *
from AdvisorController import *
from Student import *

class RegisterSystem:
    
    courseController = CourseController()
    #studentController = StudentController()
    #advisorController = AdvisorController()
    global courses
    courses = courseController.createCourse()
    #students = studentController.createStudent()
    #advisors = advisorController.createAdvisor()

    #courseController.printCourses(courses)
student1 = Student("enes","sagiroglu","150119725","","","","","","","","","","","","","","")

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
    Semester: {student._semester}
    """)

def registrationProcess(student1: Student):
    student = student1
    semesterCourses = []

    for course in courses:
        if course._semester._semesterName == student._semester._semesterName:
            semesterCourses.append(course)

    if len(student.selectedCourses) == 0:
        
        for course in student.transcript.failedCourses:
            if course._semester._semesterName == student._semester._semesterName:
                student._selectedCourses.append(course)
    
    for course in courses:
        if course._semester._semesterName == student._semester._semesterName:
            print(f"Course ID: [{course._courseId}] Course Name: {course._courseCode} {course._name}")
        else:
            pass
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

            #   CHECKERLAR BURAYA
            student._selectedCourses.append(temp_course)
            registrationProcess(student)
    except ValueError as ve:
        print(ve)
        registrationProcess(student)

    

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
        # SEND TO ADVISOR
        studentOptions(student)
    elif option == 0:
        login()


try:
    currentUser = login()
    if type(currentUser) == Student:
        studentMenu()
    elif type(currentUser) == Advisor:
        pass
except TypeError as tp:
    print("An unidentified error has occurred, you are being redirected to the login page")
    login()


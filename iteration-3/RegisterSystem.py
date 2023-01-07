from CourseController import *
from StudentController import *
from AdvisorController import *
from Student import *

class RegisterSystem:
    
    courseController = CourseController()
    #studentController = StudentController()
    #advisorController = AdvisorController()

    courses = courseController.createCourse()
    #students = studentController.createStudent()
    #advisors = advisorController.createAdvisor()

    #courseController.printCourses(courses)
student1 = Student("enes","sagiroglu","150119725","","","","","","","","","","","","","","")

def Login():
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
            Login()
        
        else:
            for temp_user in students:
                if temp_user._username == username and temp_user._password == password:
                    user = temp_user
                    return user
            print("User not found") 
            Login()


    except ValueError as ve:
        print(ve)
        Login()
    
    

currentUser = Login()


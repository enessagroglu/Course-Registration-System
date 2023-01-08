from Student import *
from Transcript import *
from Semester import *
import json
from CourseController import *

global coursesStudent

coursesStudent = []
courseController = CourseController()

coursesStudent = courseController.createCourse()

class StudentController:
    def __init__(self):
        self.hm_student = {}  # attribute studentMap as dictionary
        self.advisors = []

    def get_student(self, id, name, surname,  semester):
        student = Student(id, name, surname,  semester)
        return student

    def get_hm_student(self):
        return self.hm_student

    def set_hm_student(self, student_map):
        self.hm_student = student_map

    def get_advisors(self):
        return self.advisors

    def set_advisors(self, advisors):
        self.advisors = advisors

   
    def createStudent(self):
        # Load the JSON data from the file
        with open('input.json', 'r', encoding="utf-8") as f:
            data = json.load(f)

        createdStudents = []

        for student_data in data['AllStudents']:
            FullName = student_data['Name'].split(" ")
            name = FullName[0]
            surname = FullName[1]
            id = student_data['StudentId']
            semester_number = student_data['CurrentSemester']
            semester = Semester(semester_number,getPeriod(semester_number))
            entryYear = student_data['Enteryear']
            selectedCourses =[]
            selectedSessions =[]
            schedule = []
            activeCourses = []
            failedCoursesStr = student_data['FailedCourses']
            failedCourse = []
            for course in failedCoursesStr:
                for ccode in coursesStudent:
                    if course['code'] == ccode._courseCode:
                        failedCourse.append(ccode)
                    else:
                        continue
            passedCourseStr = student_data['PassedCourses']
            passedCourse = []
            for course in passedCourseStr:
                for ccode in coursesStudent:
                    if course['code'] == ccode._courseCode:
                        passedCourse.append(ccode)
                    else:
                        continue
            nonTakenCourses = []
            for course in coursesStudent:
                if course not in passedCourse and course not in failedCourse:
                    nonTakenCourses.append(course)
            totalCredits = student_data['TotalGivenCredits']

            grades = []

            past_courses = []

            past_courses.extend(passedCourseStr)
            past_courses.extend(failedCoursesStr)
            
            
            for course in past_courses:
           
                grades.append([course['code'] , course['letterGrade']])
                

            transcript = Transcript(totalCredits,0,passedCourse,failedCourse,grades)
            transcript.calculateGPA()

            student = Student(name,surname,id,semester,transcript,selectedCourses,selectedSessions,entryYear,schedule,activeCourses,nonTakenCourses)
            createdStudents.append(student)

        return createdStudents




            

    def print_students(self, students: List[Student]):
       for student in students:
        print(f"Name: {student._name} Surname: {student._surname} Email: {student._email} gpa:{student._transcript.gpa}")

def getPeriod(semesterNo):
        if (semesterNo % 2) == 0:
            return "Spring"
        else:
            return "Fall"


student_controller = StudentController()

studentss = student_controller.createStudent()

student_controller.print_students(studentss)

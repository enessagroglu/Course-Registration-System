import random
from Course import Course
from Grade import Grade


class Transcript(object):
    def __init__(self, totalCredits=0, gpa=0, passedCourses=None, failedCourses=None):
        self.totalCredits = totalCredits
        self.gpa = gpa
        self.passedCourses = passedCourses or []
        self.failedCourses = failedCourses or []
        self.grades = []

        
    def calculatePassFailCourses(self, course : Course):
        grade = Grade(course, random.randint(0, 100))  # Create a random grade for the course
        if grade.hasPassed() and  course not in self.passedCourses:  # Check if the course has been passed
            self.totalCredits += course.credit  # Add the course credits to the total credits
            self.passedCourses.append(course)  # Add the course to the list of passed courses
            self.grades.append([course,grade]) 
        elif grade.hasPassed()==False and course not in self.failedCourses:
            self.failedCourses.append(course)  # Add the course to the list of failed courses
            self.grades.append([course,grade]) 

    def totalGivenCredits(self):
        totalCredits = 0
        for course in self.passedCourses:
            totalCredits += course.credit

        for course in self.failedCourses:
            totalCredits += course.credits

        return totalCredits
    
    def calculateGPA(self):

        grade_point_values = {
            "FF": 0,
            "FD": 0.5,
            "DD": 1,
            "DC": 1.5,
            "CC": 2,
            "CB": 2.5,
            "BB": 3,
            "BA": 3.5,
            "AA": 4
        }

        total_credit_hours = 0
        total_grade_points = 0
        for course, grade in self.grades:
            total_credit_hours += course.credit
            total_grade_points += course.credit * grade_point_values[grade.letterGrade]

        if total_credit_hours == 0:
            return 0
        else:
            self.gpa = total_grade_points / total_credit_hours
            return self.gpa
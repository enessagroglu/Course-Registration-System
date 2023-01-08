import random
from Course import Course
from Course import *
from typing import List



class Transcript(object):
    def __init__(self, totalCredits: int, gpa: float, passedCourses: List[Course], failedCourses: List[Course], grades: List[str]):
        self.totalCredits = totalCredits
        self.passedCourses = passedCourses
        self.failedCourses = failedCourses
        self.grades = grades
        self.gpa = self.calculateGPA()

        
   
    
    def calculateGPA(self):
        past_courses = []
        past_courses.extend(self.passedCourses)
        past_courses.extend(self.failedCourses)

        grade_point_values = {
            "FF": 0,
            "FD": 0.5,
            "DD": 1,
            "DC": 1.5,
            "CC": 2,
            "CB": 2.5,
            "BB": 3,
            "BA": 3.5,
            "AB": 3.5,
            "AA": 4
        }

        
        total_grade_points = 0
        
        global credit
        
        for i in range(len(self.grades)):
            point = self.grades[i][1]
            credit = 0
            for course in past_courses:
                if course._courseCode == self.grades[i][0]:
                    credit = course._credit

            total_grade_points += credit * grade_point_values[point]
        
        if self.totalCredits == 0:
            return 0
        else:
            self.gpa = total_grade_points / self.totalCredits
            self.gpa = int(100*self.gpa)/100
            return self.gpa
                

            

        # if total_credit_hours == 0:
        #     return 0
        # else:
        #     self.gpa = total_grade_points / total_credit_hours
        #     return self.gpa


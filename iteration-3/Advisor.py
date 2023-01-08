from Person import *
from typing import List
from Student import *
from CollisionChecker import *




class Advisor(Person):
    def __init__(self, name: str,surname: str, id: str):
        super().__init__(name, surname,id)
        self._password = "123"
    

    def approve(self, student: Student)->bool:
        if selectedCourseCollision(student) == False:
            print("CollisionError")
            return False
        else:
            for course in student._selectedCourses:
                student._activeCourses.append(course)
            for course in student._activeCourses:
                student._selectedCourses.remove(course)
            print("Your Selected Courses have been approved")
            return True
    
 

def selectedCourseCollision(student: Student):
    for i in range(len(student._selectedCourses)):
        for j in range(i + 1, len(student._selectedCourses)):
            collision1 = CollisionChecker(student._selectedCourses[i]._schedule,student._selectedCourses[j]._schedule)
            if(collision1.checkCollision()):
                print("""Course Name: {} Schedule: {}
                        Course Name: {} Schedule: {}
                        Ther are collapsed """.format(
                        student._selectedCourses[i].courseCode,
                        student._selectedCourses[i]._schedule,
                        student._selectedCourses[j].courseCode,
                        student._selectedCourses[j]._schedule))
                    
                print("\n")
                return False
    
    def __str__(self):
        return f"Advisor Name:{self._name},Advisor Surname:{self._surname},Advisor ID:{self._id} "


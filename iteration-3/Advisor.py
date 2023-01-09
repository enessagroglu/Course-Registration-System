from Person import *
from typing import List
from Student import *
from CollisionChecker import *
import logging

logger = logging.getLogger(__name__)

logger.setLevel(logging.DEBUG)

file_handler = logging.FileHandler('app.log')

import logging

logging.basicConfig(filename='app.log', filemode='w', format='%(name)s - %(levelname)s - %(message)s')
logging.warning('This will get logged to a file')

logger.addHandler(file_handler)


class Advisor(Person):
    def __init__(self, name: str,surname: str, id: str):
        super().__init__(name, surname,id)
        self._password = "123"
    

    def approve(self, student: Student)->bool:
        if selectedCourseCollision(student) == False:
            return False
        else:
            for course in student._selectedCourses:
                student._activeCourses.append(course)
                course.courseCurrentStudentNumber += 1
            for course in student._activeCourses:
                student._selectedCourses.remove(course)

            print("Your Selected Courses have been approved")
            return True
    
 

def selectedCourseCollision(student: Student):
    try:
        for i in range(len(student._selectedCourses)):
            for j in range(i + 1, len(student._selectedCourses)):
                collision1 = CollisionChecker(student._selectedCourses[i]._schedule,student._selectedCourses[j]._schedule)
                if(not collision1.checkCollision()):
                    print("""Course Name: {} Schedule: {}
                            Course Name: {} Schedule: {}
                            Ther are collapsed """.format(
                            student._selectedCourses[i].courseCode,
                            student._selectedCourses[i]._schedule,
                            student._selectedCourses[j].courseCode,
                            student._selectedCourses[j]._schedule))

                    print("\n")
                    return False
    except Exception as e:
        print(e)
        logger.error(e)
        return False


    
    def __str__(self):
        return f"Advisor Name:{self._name},Advisor Surname:{self._surname},Advisor ID:{self._id} "


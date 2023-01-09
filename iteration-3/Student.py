from typing import List
from Person import Person
from Semester import Semester
from Transcript import Transcript
from Course import *
from CourseSession import CourseSession
from CollisionChecker import *

class Student(Person):
    def __init__(self, name: str, surname: str, id: int, semester: Semester, transcript: Transcript, selectedCourses: List[Course], selectedSessions: CourseSession, entryYear: int, schedule: List[list], activeCourses: List[Course],  nonTakenCourses: List[Course]):
        super().__init__(name, surname, id)
        self._semester = semester
        self._transcript = transcript
        self._selectedCourses = selectedCourses
        self._selectedSessions = selectedSessions
        self._entryYear = entryYear
        self._schedule = schedule
        self._activeCourses = activeCourses
        self._nonTakenCourses = nonTakenCourses
        self._password = "123"

    def get_full_name(self):
        return f"{self._name} {self._surname}"

    
    # Getter and setter methods for the semester attribute
    @property
    def semester(self):
        return self._semester

    @semester.setter
    def semester(self, value: Semester):
        self._semester = value

    # Getter and setter methods for the transcript attribute
    @property
    def transcript(self):
        return self._transcript

    @transcript.setter
    def transcript(self, value: Transcript):
        self._transcript = value
    
    # Getter and setter methods for the selectedCourses attribute
    @property
    def selectedCourses(self):
        return self._selectedCourses

    @selectedCourses.setter
    def selectedCourses(self, value: List[Course]):
        self._selectedCourses = value

    # Getter and setter methods for the selectedSessions attribute
    @property
    def selectedSessions(self):
        return self._selectedSessions

    @selectedSessions.setter
    def selectedSessions(self, value: CourseSession):
        self._selectedSessions = value

    # Getter and setter methods for the entryYear attribute
    @property
    def entryYear(self):
        return self._entryYear

    @entryYear.setter
    def entryYear(self, value: int):
        self._entryYear = value
     

    # Getter and setter methods for the activeCourses attribute
    @property
    def activeCourses(self):
        return self._activeCourses
    
    @activeCourses.setter
    def activeCourses(self, value: List[Course]):
        self._activeCourses = value

    # Getter and setter methods for the nonTakenCourses attribute
    @property
    def nonTakenCourses(self):
        return self._nonTakenCourses

    @nonTakenCourses.setter
    def nonTakenCourses(self, value: List[Course]):
        self._nonTakenCourses = value

    # Getter and setter methods for the failed_courses attribute
    @property
    def failedCourses(self):
        return self._failedCourses

    @failedCourses.setter
    def failedCourses(self, value: List[Course]):
        self._failedCourses = value

    

def calculateCumulativeGpa(self):
    try:
        transcript = Transcript()
        cCredit = transcript.cumulativeCredit
        cGrade = transcript.cumulativeCredit
        result = cGrade/cCredit
        self._cgpa = result
    except Exception as e:
        print(e)
    except ZeroDivisionError as z:
        print(z)
    
    def printNonTakenCourses(self):
        try:
            for course in self._nonTakenCourses:
                print(course)
        except Exception as e:
            print(e)

    def printFailedCourses(self):
        try:
            for course in self._failedCourses:
                print(course)
        except Exception as e:
            print(e)

    def printSelectedSessions(self):
        try:
            for courseSession in self._selectedSessions:
                print(courseSession)
        except Exception as e:
            print(e)


    def addNonTakenCourse(self,course: Course):
        try:
            if course not in self.nonTakenCourses:
                self.nonTakenCourses.append(course)
        except Exception as e:
            print(e)


    def __str__(self):
        return f"Student(name='{self._name}', surname='{self._surname}', id={self._id}, emails='{self._email}', semester='{self._semester}',  transcript='{self._transcript}', selected_courses='{self._selectedCourses}', selected_sessions='{self._selectedSessions}', entry_year={self._entryYear}, schedule='{self._schedule}', cgpa={self._cgpa}, active_courses='{self._activeCourses}', past_courses='{self._pastCourses}', non_taken_courses='{self._nonTakenCourses}', failed_courses='{self._failedCourses}')"

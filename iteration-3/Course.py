from typing import List, TypeVar
from CourseSession import CourseSession
from Semester import Semester


Course = TypeVar('Course', bound='Course')


class Course:
    def __init__(self, courseId: str, name: str, courseCode: str, requiredCredits: int ,semesterNumber: int, courseType: str,
    courseCurrentStudentNumber: int, semester: Semester, quota: int, credit: int, sessionCount: int ,sessions: List[CourseSession],prerequisites: List[str],schedule: List[list]):
        self._courseId = courseId
        self._name = name
        self._courseCode = courseCode
        self._requiredCredits = requiredCredits
        self._semesterNumber = semesterNumber
        self._courseType = courseType
        self._courseCurrentStudentNumber = courseCurrentStudentNumber
        self._semester = semester
        self._quota = quota
        self._credit = credit
        self._sessionCount = sessionCount
        self._sessions = sessions
        self._prerequisites = prerequisites
        self._schedule = schedule

    @property
    def courseId(self):
        return self._courseId
    
    @property
    def name(self):
        return self._name
    
    @name.setter
    def name(self, name):
        self._name = name
    @property
    def courseCode(self):
        return self._courseCode

    @courseCode.setter
    def courseCode(self, courseCode: str):
        self._courseCode = courseCode

    @property
    def requiredCredits(self):
        return self._requiredCredits

    @requiredCredits.setter
    def requiredCredits(self, requiredCredits: int):
        self._required_credits = requiredCredits

    @property
    def semesterNumber(self):
        return self._semesterNumber

    @semesterNumber.setter
    def semesterNumber(self, semesterNumber: int):
        self._semesterNumber = semesterNumber

    @property
    def courseType(self):
        return self._courseType

    @courseType.setter
    def courseType(self, courseType: str):
        self._courseType = courseType

    @property
    def courseCurrentStudentNumber(self):
        return self._courseCurrentStudentNumber

    @courseCurrentStudentNumber.setter
    def courseCurrentStudentNumber(self, courseCurrentStudentNumber: int):
        self._courseCurrentStudentNumber = courseCurrentStudentNumber
    
    @property
    def semester(self):
        return self._semester
    
    @semester.setter
    def semester(self, semester):
        self._semester = semester
    
    @property
    def quota(self):
        return self._quota
    
    @quota.setter
    def quota(self, quota):
        try:
            if quota < 0:
                raise ValueError("Quota must be a positive integer.")
        except ValueError as e:
            print(e)
        else:
            self._quota = quota
    
    @property
    def credit(self):
        return self._credit
    
    @credit.setter
    def credit(self, credit):
        try:
            if credit < 0:
                raise ValueError("Credit must be a positive integer.")
        except ValueError as e:
            print(e)
        else:
            self._credit = credit
    
    @property
    def sessionCount(self):
        return self._sessionCount
    
    @credit.setter
    def sessionCount(self, sessionCount):
        try:
            if sessionCount < 0:
                raise ValueError("sessionCount must be a positive integer.")
        except ValueError as e:
            print(e)
        else:
            self._sessionCount = sessionCount
    
    @property
    def sessions(self):
        return self._sessions
    
    @sessions.setter
    def session(self, sessions):
        self._sessions = sessions
    
    @property
    def prequisites(self):
        return self._prequisites
    
    @prequisites.setter
    def prequisites(self, prequisites):
        self._prequisites = prequisites
   

    def __str__(self):
        return f"Course(course_id='{self._courseId}', name='{self._name}', course_code='{self._courseCode}', required_credits={self._requiredCredits}, semester_number={self._semesterNumber}, course_type='{self._courseType}', course_current_student_number={self._courseCurrentStudentNumber}, semester='{self._semester}', quota={self._quota}, credit={self._credit}, session_count={self._sessionCount}, sessions='{self._sessions}', prequisites='{self._prequisites}'')"
from Course import Course

class TechnicalCourse(Course):
    def __str__(self):
        return f"TechnicalCourse(course_id='{self._courseId}', name='{self._name}', course_code='{self._courseCode}', required_credits={self._requiredCredits}, semester_number={self._semesterNumber}, course_type='{self._courseType}', course_current_student_number={self._courseCurrentStudentNumber}, semester='{self._semester}', quota={self._quota}, credit={self._credit}, session_count={self._sessionCount}, sessions='{self._sessions}', prerequisites='{self._prerequisites}')"
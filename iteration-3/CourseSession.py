class CourseSession:
    def __init__(self, session_id, schedule_list):
        self.session_id = session_id
        self.schedule_list = schedule_list

    def get_session_id(self):
        return self.session_id

    def set_session_id(self, session_id):
        self.session_id = session_id

    def get_course(self):
        return self.course

    def set_course(self, course):
        self.course = course

    def get_schedule_list(self):
        return self.schedule_list

    def set_schedule_list(self, schedule_list):
        self.schedule_list = schedule_list

    def __str__(self):
        return "CourseSession{{ sessionId={}, scheduleList={} }}".format(self.session_id,self.schedule_list)
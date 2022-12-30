class Semester:

    def __init__(self, semesterNo:str, semesterName:str):
        self._semesterNo = semesterNo
        self._semesterName = semesterName


    @property
    def semesterNo(self):
        return self._semesterNo
    
    @semesterNo.setter
    def semesterNo(self, semesterNo):
        self._semesterNo = semesterNo

    @property
    def semesterName(self):
        return self._semesterName
    
    @semesterName.setter
    def semesterName(self, semesterName):
        self._semesterName = semesterName
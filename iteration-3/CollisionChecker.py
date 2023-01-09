#python -m unittest TestCollisionChecker.py
# cakisma varsa checker failledi yani false dondu
# cakisma yoksa checker ilerledi yani true dondu
from typing import List
from Student import *
class CollisionChecker(): 
    flag = 0
    def __init__(self, first_course: List[list], second_course:List[list]):

        # kucugun for dongusu disina yazicaz burda belirliyoruz
        if(len(first_course)<= len(second_course)):
            self.first_course_schedule = first_course
            self.second_course_schedule = second_course
        else:
            self.first_course_schedule = second_course
            self.second_course_schedule = first_course

    def checkCollision(self):
        if(len(self.first_course_schedule) or len(self.second_course_schedule)):
            return False
        # 1.dersin schedulunda donuyor
        for i in range(len(self.first_course_schedule)):
            # 2.dersin schedulunda donuyor
            for j in range(len(self.second_course_schedule)):
                # 1.dersin schedulunda i. indexteki butun dayleri, 2.dersin schedulunda j. indexteki dayle 
                # karsilatiriyor gunler cakismisyosa devam zaten.
      
                if(int(self.first_course_schedule[i]['day'])!=int(self.second_course_schedule[j]['day'])):
                    print(self.first_course_schedule[i])
                    print(self.second_course_schedule[j])
                    print("cakismiyor")
                    continue
                num1Sum = int(self.first_course_schedule[i]["timeEnd"])+int(self.first_course_schedule[i]["timeStart"])
                num2Sum = int(self.second_course_schedule[j]["timeEnd"])+int(self.second_course_schedule[j]["timeStart"])
                num1Dif = int(self.first_course_schedule[i]["timeEnd"])-int(self.first_course_schedule[i]["timeStart"])
                num2Dif = int(self.second_course_schedule[j]["timeEnd"])-int(self.second_course_schedule[j]["timeStart"])

                if(abs(num1Sum-num2Sum)>= (num1Dif+num2Dif)):
                    print(self.first_course_schedule[i])
                    print(self.second_course_schedule[j])
                    print("cakismiyor")
                else:
                    print(self.first_course_schedule[i])
                    print(self.second_course_schedule[j])
                    flag = 1
                    print("cakisiyor")
        if flag ==1:
            return True
        else:
            False

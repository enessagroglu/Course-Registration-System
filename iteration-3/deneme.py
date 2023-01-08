from InputCreator import *
import json

inputCreator()

with open('input.json', 'r',encoding="utf-8") as f:
    data = json.load(f)


        # Iterate over the list of courses in the JSON data
    for course_data in data['AllStudents']:
        print(course_data)
        print("\n ** \n")


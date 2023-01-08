import json
print("killa hakan")
with open('courses.json', 'r') as f:
            data = json.load(f)
courses = []
for course_data in data["courses"]:
    if "schedule" in course_data:
        print("CourseName {}".format(course_data["CourseName"]))
        for course_schedule in course_data["schedule"]:
            print("Day:{} Time Start:{} TimeEnd:{}".format(course_schedule["day"],course_schedule["timeStart"],course_schedule["timeEnd"]))
    print("\n")        
           
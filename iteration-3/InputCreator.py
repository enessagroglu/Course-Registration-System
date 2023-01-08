import json
import random

def inputCreator():
    # Read in the names and courses JSON files
    with open("names.json", encoding="utf-8") as f:
       names = json.load(f,)
    with open("courses.json", encoding="utf-8") as f:
       courses = json.load(f)
       

    all_students = []


    # Loop through the names
    for name in names["names"]:
        passed_courses = []
        failed_courses = []
        passed_courses_prereq = []
        total_given_credits = 0

        Enteryear = random.choice([2017,2018,2019,2020,2021,2022])
        year = 2022 - Enteryear 
        inc = random.choice([0,1])
        current_semester= (year*2)+inc
        
        if current_semester > 8 :
            current_semester = 8
        
        random_number_3 = 100 + random.randint(0, 900)
        student_id = "1501" + str(Enteryear- 2000) + str(random_number_3)
        

        
        
        for course in courses["courses"]:
            if course["courseSemester"]>current_semester:
                continue
            # Generate a random number between 0 and 1
            chance = random.uniform(0, 1)
            
            
            if chance < 0.5 - (current_semester * 0.01):
                # Student has failed the course
                failed_courses.append({
                    "code": course["CourseCode"],
                    "name": course["CourseName"],
                    "grade" : int(random.uniform(0, 50)),
                    "letterGrade": random.choice(["FF"])
                })
            else:
                # Student has passed the course
                total_given_credits += course["Credit"]
                grade = int(random.uniform(50, 100))
                lettergrade = "AA", "AB", "BB" , "BC" ,"CC","DC","DD"
                if grade >= 90:
                    lettergrade = "AA"
                elif grade >= 85:
                    lettergrade = "AB"
                elif grade >= 80:
                    lettergrade = "BA"
                elif grade >= 75:
                    lettergrade = "CB"
                elif grade >= 65:
                    lettergrade = "CC"
                elif grade >= 55:
                    lettergrade = "DC"
                elif grade >= 50:
                    lettergrade = "DD"
                passed_courses.append({
                    "code": course["CourseCode"],
                    "name": course["CourseName"],
                    "grade": grade,
                    "letterGrade": lettergrade
                })
                if course["PrerequisiteCourseCodes"]:
                    passed_courses_prereq.extend(course["PrerequisiteCourseCodes"])
                for i in range(len(passed_courses)):
                    if course["PrerequisiteCourseCodes"] == passed_courses[i]["code"]:
                        passed_courses_prereq.remove(course["PrerequisiteCourseCodes"])
                        break

        # Boş stringleri sil
        preRequisite = [val for val in passed_courses_prereq if val != ""]             
             
        # Create the student object
        student = {
            "Name": name,
            "StudentId":student_id,
            "preRequisite" : preRequisite,
            "Enteryear": Enteryear,
            "CurrentSemester": current_semester,
            "PassedCourses": passed_courses,
            "FailedCourses": failed_courses,
            "TotalGivenCredits": total_given_credits
        }
        
        # Add the student object to the list
        all_students.append(student)

    # Create the final output JSON object
    output = {
        "AllStudents": all_students
    }

    # Write the output to a file
    with open("input.json", "w", encoding="utf-8") as f:
        json.dump(output, f, ensure_ascii=False)


inputCreator()



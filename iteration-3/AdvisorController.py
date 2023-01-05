from Advisor import *
import json

class AdvisorController:
    def __init__(self, AdvisorList: List[Advisor]):
        self._AdvisorList = AdvisorList
    
    @property
    def AdvisorList(self):
        return self._AdvisorList
    
    @AdvisorList.setter
    def AdvisorList(self, value: List[Advisor]):
        self._AdvisorList = value
    
    def createAdvisor(self):
        with open('advisors.json', 'r') as f:
            data = json.load(f)
        
        advisors = []
        count = 1
        
        for advisor_data in data['advisors']:
            advisorID = str(count)
            name = advisor_data['name']
            surname = advisor_data['surname']
            clients = []

            advisor = Advisor(name,surname,advisorID,clients)

            advisors.append(advisor)
            count += 1

        return advisors

    def printAdvisors(self, advisors):
    # Print the list of Advisor objects
        print("**Created Advisors:")
        for advisor in advisors:
            print(advisor)
            print("")
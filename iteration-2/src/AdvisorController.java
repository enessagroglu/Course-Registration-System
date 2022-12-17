import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AdvisorController {
    private Map<String,Advisor> hmAdvisor;

    public AdvisorController() {this.hmAdvisor = new HashMap<>();}

    public Map<String, Advisor> getHMadvisor() {return hmAdvisor;}

    public void setHMadvisor(Map<String, Advisor> hmAdvisor) {this.hmAdvisor = hmAdvisor;}

    public void createAdvisor(int id, String name, String surname) {
        Advisor advisor = new Advisor(id, name, surname);
        String fullName = advisor.getFullName();
        Map<String,Advisor> hmAdvisor = this.hmAdvisor;
        hmAdvisor.put(fullName, advisor);
    }
    public void printAdvisors() {
        //method iterates over the values in the hmAdvisor collection and prints out each Advisor object's full name
        // and the Advisor object itself.
        for (Advisor advisor : hmAdvisor.values()) {
            System.out.println(advisor.getFullName() + " = " + advisor);
        }
    }
    public Advisor searchAdvisor(String fullName) {
        //This version of the method iterates over the values in the hmAdvisor collection and compares each Advisor
        // object's full name to the search name. If a match is found, the foundAdvisor variable is updated and the loop
        // is broken. If the loop completes without finding a match, foundAdvisor will remain null.
        Advisor foundAdvisor = null;
        for (Advisor advisor : hmAdvisor.values()) {
            if (advisor.getFullName().equals(fullName)) {
                foundAdvisor = advisor;
                break;
            }
        }
        return foundAdvisor;
    }

}

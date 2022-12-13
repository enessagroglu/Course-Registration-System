import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    private int id;
    private String name;
    private String surname;
    private List<String> emails;

    // constructors
    protected Person(int id, String name, String surname, List<String> emails) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.emails = emails;
    }
    protected Person(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    // getter and setter methods
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getSurname() {return surname;}
    public void setSurname(String surname) {this.surname = surname;}
    public List<String> getEmails() {return emails;}
    public void setEmails(List<String> emails) {this.emails = emails;}
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

}
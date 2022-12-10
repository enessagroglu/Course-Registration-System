public abstract class Person {
    private String name;
    private String surname;
    private String email;
    private String password;

    // constructor
    public Person(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    // getter and setter methods
    public String getName() {return this.name;}

    public void setName(String name) {this.name = name;}

    public String getSurname() {return this.surname;}

    public void setSurname(String surname) {this.surname = surname;}

    public String getEmail() {return this.email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return this.password;}

    public void setPassword(String password) {this.password = password;}

    // login abstract method
    public abstract boolean login(String email, String password);
}
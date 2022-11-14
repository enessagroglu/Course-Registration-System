public abstract class Person {
    private String fullName;
    private String email;
    private String password;

    protected Person() {
    }

    abstract String getFullName();

    abstract String getEmail();

    abstract String getPassword();


}

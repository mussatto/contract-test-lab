package lab.api;

public class Person {
    private final long id;
    private final String firstName;
    private final String lastName;

    public Person(long id, String firstName, String bee) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = bee;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

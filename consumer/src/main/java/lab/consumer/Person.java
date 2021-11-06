package lab.consumer;

public class Person {
    private long id;
    private String firstName;
    private String lastName;

    public Person(){

    }

    public Person(long id, String firstName, String bee) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = bee;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

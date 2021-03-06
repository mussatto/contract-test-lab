package lab.api;

import java.util.HashMap;
import java.util.Map;

public class PersonService {
    private final Map<Long, Person> personMap;

    public PersonService() {
        personMap = new HashMap<>();
        personMap.put(1L, new Person(1L, "Richard", "Gere"));
        personMap.put(2L, new Person(2L, "Emma", "Choplin"));
        personMap.put(3L, new Person(3L, "Anna", "Carolina"));
    }

    public Person findPersonById(long l) {
        return personMap.get(l);
    }
}

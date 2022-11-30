package lab.api;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;

@SpringBootTest(classes = ContractTestApplication.class)
public class ContractBaseClass {

    @Autowired
    PersonRestController personRestController;

    @MockBean
    PersonService personService;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(personRestController);

        Mockito.when(personService.findPersonById(1L))
                .thenReturn(new Person(1L, "foo","baa"));
        Mockito.when(personService.findPersonById(2L))
                .thenReturn(new Person(2L, "consumer","A"));
        Mockito.when(personService.findPersonById(3L))
                .thenReturn(new Person(3L, "consumer","B"));


        Mockito.when(personService.findAll())
                .thenReturn(
                        Arrays.asList(
                                new Person(1L, "Richard","Smith"),
                                new Person(2L, "Emma","Doe"),
                                new Person(3L, "Anna","Lopez")
                        )
                );
    }
}

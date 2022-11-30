package lab.consumer;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerExtension;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsumerBTest {

    @RegisterExtension
    public static StubRunnerExtension stubRunner = new StubRunnerExtension()
            //SAME AS CONSUMER!!!
            .downloadStub("lab.contractest", "api", "0.1-SNAPSHOT", "stubs")
            .withPort(8100)
            .stubsMode(StubRunnerProperties.StubsMode.CLASSPATH);

    @Test
    public void getPerson3() {
        // given:
        RestTemplate restTemplate = new RestTemplate();

        // when:
        ResponseEntity<Person> personResponseEntity = restTemplate.getForEntity("http://localhost:8100/person/3", Person.class);

        // then:
        assertThat(personResponseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(personResponseEntity.getBody().getId()).isEqualTo(3L);
        assertThat(personResponseEntity.getBody().getFirstName()).isEqualTo("consumer");
        assertThat(personResponseEntity.getBody().getLastName()).isEqualTo("B");
    }

    @Test
    public void getPersons() {
        // given:
        RestTemplate restTemplate = new RestTemplate();

        // when:
        ResponseEntity<Person[]> personResponseEntity = restTemplate.getForEntity("http://localhost:8100/person", Person[].class);
        Person[] persons = personResponseEntity.getBody();
        // then:
        assertThat(personResponseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(persons).isNotEmpty();
        assertThat(persons).hasSize(3);
    }
}

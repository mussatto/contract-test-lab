package lab.consumer;

import org.assertj.core.api.BDDAssertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerExtension;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneralTest {

    @RegisterExtension
    public static StubRunnerExtension stubRunner = new StubRunnerExtension()
            //SAME AS CONSUMER!!!
            .downloadStub("lab.contractest", "api", "0.1-SNAPSHOT", "stubs")
            .withPort(8100)
            .stubsMode(StubRunnerProperties.StubsMode.CLASSPATH);

    @Test
    public void getPerson1() {
        // given:
        RestTemplate restTemplate = new RestTemplate();

        // when:
        ResponseEntity<Person> personResponseEntity = restTemplate.getForEntity("http://localhost:8100/person/1", Person.class);

        // then:
        assertThat(personResponseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(personResponseEntity.getBody().getId()).isEqualTo(1L);
        assertThat(personResponseEntity.getBody().getFirstName()).isEqualTo("foo");
        assertThat(personResponseEntity.getBody().getLastName()).isEqualTo("baa");
    }
}

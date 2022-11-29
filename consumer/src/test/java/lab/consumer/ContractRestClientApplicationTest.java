package lab.consumer;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerExtension;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ContractRestClientApplicationTest {

    @RegisterExtension
    public StubRunnerExtension stubRunner = new StubRunnerExtension()
            .downloadStub("lab.contract", "contract", "1.0", "stubs")
            .withPort(8100)
            .stubsMode(StubRunnerProperties.StubsMode.LOCAL);

    @Test
    public void get_person_from_service_contract() {
        // given:
        RestTemplate restTemplate = new RestTemplate();

        // when:
        ResponseEntity<Person> personResponseEntity = restTemplate.getForEntity("http://localhost:8100/person/1", Person.class);

        // then:
        BDDAssertions.then(personResponseEntity.getStatusCodeValue()).isEqualTo(200);
        BDDAssertions.then(personResponseEntity.getBody().getId()).isEqualTo(1L);
        BDDAssertions.then(personResponseEntity.getBody().getFirstName()).isEqualTo("foo");
        BDDAssertions.then(personResponseEntity.getBody().getLastName()).isEqualTo("baa");
    }
}

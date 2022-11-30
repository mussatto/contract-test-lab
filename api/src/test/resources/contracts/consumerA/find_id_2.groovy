package contracts.consumerA

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return person by id=2"

    request {
        url "/person/2"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                id: 2,
                firstName: "consumer",
                lastName: "A"
        )
    }
}
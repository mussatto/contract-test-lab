package contracts.consumerB

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return person by id=3"

    request {
        url "/person/3"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                id: 3,
                firstName: "consumer",
                lastName: "B"
        )
    }
}
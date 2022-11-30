package contracts.consumerB

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return a list of persons"

    request {
        url "/person"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body '''
            [
                {
                    "id": 1,
                    "firstName": "Richard",
                    "lastName": "Smith"
                },
                {
                    "id": 2,
                    "firstName": "Emma",
                    "lastName": "Doe"
                },
                {
                    "id": 3,
                    "firstName": "Anna",
                    "lastName": "Lopez"
                }
            ]
        '''
    }
}
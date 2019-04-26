import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("Sample contract description")
    request {
        method GET()
        headers {
            accept(applicationJson())
        }
        url('/producer/api/v1/sample') {
            queryParameters {
                parameter("id", 122L)
            }
        }
    }
    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body(file("response.json"))
    }
}
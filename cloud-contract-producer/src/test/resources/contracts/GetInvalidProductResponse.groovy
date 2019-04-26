import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Get Invalid Product Contract"
    request {
        method GET()
        headers {
            accept(applicationJson())
        }
        url('/producer/api/v1/products/3')
    }
    response {
        status EXPECTATION_FAILED()
        headers {
            contentType(applicationJson())
            body(file("GET_INVALID_PRODUCT_RESPONSE.json"))
        }
    }
}
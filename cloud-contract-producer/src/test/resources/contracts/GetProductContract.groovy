import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Get product by id contract"
    request {
        method GET()
        headers {
            accept(applicationJson())
        }
        url('/producer/api/v1/products/1')
    }
    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body(file("GET_PRODUCT_RESPONSE.json"))
    }
}
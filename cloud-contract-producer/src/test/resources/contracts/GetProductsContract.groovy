import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Get all products contract"
    request {
        method GET()
        headers {
            accept(applicationJson())
        }
        url('/producer/api/v1/products')
    }

    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body(file("GET_PRODUCTS_RESPONSE.json"))
    }
}
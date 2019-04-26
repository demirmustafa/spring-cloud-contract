package io.github.demirmustafa.cloudcontract.consumer;

import io.github.demirmustafa.cloudcontract.consumer.model.Product;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Mustafa Demir <mustafa.demir@sahabt.com>
 */
@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureStubRunner(ids = "io.github.demirmustafa:producer-contract:1.0.0:8090", stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class ProducerVerifierTest {


    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void getProductTest() {
        // given
        Integer productId = 1;

        // when
        //ResponseEntity<Product> responseEntity = restTemplate.getForEntity("http://localhost:8090/producer/api/v1/products/"+ productId, Product.class);
        /*assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(responseEntity.getBody().getName()).isEqualTo("Introduction to Java Programming");*/
                Product product = webTestClient.get()
                .uri("http://localhost:8090/producer/api/v1/products/"+ productId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Product.class)
                .returnResult()
                .getResponseBody();

        // then

        assertThat(product).isNotNull();
        assertThat(product.getName()).isEqualTo("Introduction to Java Programming");

    }


   /* public class Config {

        @Bean
        public RestTemplate restTemplate(){
            return new RestTemplate();
        }
    }*/
}

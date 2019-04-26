package io.github.demirmustafa.cloudcontract.producer;

import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CloudContractProducerApplicationTests {

    @Autowired
    private WebApplicationContext context;

    @LocalServerPort
    private Integer port;

    @Before
    public void setup(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;

        DefaultMockMvcBuilder defaultMockMvcBuilder = MockMvcBuilders.webAppContextSetup(context);
        RestAssuredMockMvc.standaloneSetup(defaultMockMvcBuilder);
    }

    @Test
    public void sampleTest() {
        assertThat(1L, equalTo(1L));
    }

}

package org.sid.springboot.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.sid.springboot.demo.main.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class HelloControllerTest {

    @Autowired
    private HelloController helloController;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void contextLoads() throws Exception {
        assertThat(helloController).isNotNull();
    }

    @Test
    public void greetingShouldReturnDefaultValue() throws Exception {
        assertThat(this.testRestTemplate.getForObject("http://localhost:" + port
                + "/hello", String.class)).contains("Hello from Springboot with War and swagger.");
    }
}

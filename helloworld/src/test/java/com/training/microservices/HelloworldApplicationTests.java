package com.training.microservices;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment; 

import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloworldApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testSpringBootApp() throws IOException
	{
		String body=restTemplate.getForObject("/",String.class);
		assertThat(new ObjectMapper().readTree(body).get("message").textValue()).isEqualTo("Hello World");
	}

}

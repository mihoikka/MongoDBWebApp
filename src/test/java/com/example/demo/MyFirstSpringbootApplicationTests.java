package com.example.demo;

import com.example.demo.api.G_Controller;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import com.example.demo.model.Character;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MyFirstSpringbootApplicationTests {

	@Autowired G_Controller g_controller;
	@Test
	void contextLoads() {
		assertThat(g_controller).isNotNull();
	}

	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;
	@Test
	void testHomePageWorks() throws Exception{
		System.out.println();
		assert(this.restTemplate.getForObject("http://localhost:" + port + "/resources/index.html", String.class).contains("Character Data Home"));
	}

}

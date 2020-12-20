package com.koch.fizzbuzz;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FizzbuzzApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void FizzbuzTrueCheck() throws Exception {
		assertTrue(
				(this.restTemplate.getForObject("http://localhost:" + port + "/fizzbuzz?low=10&&high=15", String.class))
						.contains("fizzbuzz"));
	}

	@Test
	public void FizzbuzFalseCheck() throws Exception {
		assertFalse(
				(this.restTemplate.getForObject("http://localhost:" + port + "/fizzbuzz?low=10&&high=14", String.class))
						.contains("fizzbuzz"));
	}
}
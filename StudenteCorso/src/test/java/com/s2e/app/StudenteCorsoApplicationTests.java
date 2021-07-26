package com.s2e.app;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.s2e.app.model.Studente;
import com.s2e.app.repository.StudenteRepository;
import static org.junit.Assert.*;

@SpringBootTest
class StudenteCorsoApplicationTests {
	@Autowired
	StudenteRepository repo;

	/*
	 * Test di un servizio Rest secondo lo status http (200, 404, 500 ecc..)
	 *
	 */
	@Test
	void givenStudents_studentsReceived_status200() throws ClientProtocolException, IOException {

		System.out.println("Test partito!");

		// Compilo la richiesta http
		HttpUriRequest request = new HttpGet("http://localhost:4209/students");

		// Eseguo la richiesta Http
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		// Controllo che lo stato sia 200
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));

		System.out.println("Test eseguito!");

	}

	@Test
	void givenStudentsDelete_deleteById() throws ClientProtocolException, IOException {
		
		int idTest = 1;
		HttpUriRequest request = new HttpDelete("http://localhost:4209/students/"+idTest);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
		Studente deleted=null;
		try {
			deleted=repo.getById(idTest);
		} catch (Exception e) {
			// TODO: handle exception
		}
		assertEquals(deleted, null);
		
	}

	@Test
	void contextLoads() {

	}

}

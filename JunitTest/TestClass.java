package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.example.demo.entity.Students;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testAddStudent() {
		Students student = new Students();
		// student.setId(null);
		student.setName(null);
		student.setCity(null);
		student.setStd(null);

		ResponseEntity<Students> postresponse = restTemplate.postForEntity("/Student/addStudent", student,
				Students.class);
		// assertNotNull(postresponse.getBody());
		assertNull(postresponse.getBody());

		assertNotNull(postresponse.getBody());

		// String name = null;

		// assertNotNull(name);

	}

	@Test
	public void updateStudent() {
		Students student = restTemplate.getForObject("/Student/update/", Students.class);
		student.setName("varathan");
		student.setStd("7th");
		restTemplate.put("/Student/update/", student);
		Students students = restTemplate.getForObject("/Student/update/", Students.class, "8th");
		assertNotNull(student);
		// assertNull(student);
	}

	@Test
	public void deleteStudent() {

		Students student = restTemplate.getForObject("/Student/delete/{id}", Students.class);
		assertNotNull(student);
		restTemplate.delete("/Student/delete/{id}");
		try {
			student = restTemplate.getForObject("/Student/delete/{id}", Students.class);
		} catch (final HttpClientErrorException exception) {
			assertEquals(exception.getStatusCode(), HttpStatus.NOT_FOUND);
		}

	}

}

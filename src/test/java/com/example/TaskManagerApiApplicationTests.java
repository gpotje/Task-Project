package com.example;


import com.example.domain.dto.task.CreateTaskRequestDto;
import com.example.domain.enuns.TaskStatus;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class TaskManagerApiApplicationTests {


	@Test
	void contextLoads() {
	}

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void should_listAll() throws Exception{
		webTestClient.get()
				.uri("/tasks")
				.exchange()
				.expectStatus().isOk();
	}

	@Test
	void should_create_task_witOut_status() throws Exception{
		CreateTaskRequestDto dto = new CreateTaskRequestDto("[EDITAL]","Ocorrendo um retorno com a inconsistência");

		webTestClient.post()
				.uri("/tasks")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.body(Mono.just(dto), CreateTaskRequestDto.class)
				.exchange()
				.expectStatus().isCreated() // 3. Verify HTTP Status 201 Created
				.expectHeader().contentType(MediaType.APPLICATION_JSON) // 4. Verify Content-Type header
				.expectBody()  // 5. Verify the JSON response body
				.jsonPath("$.id").isNotEmpty();

	}

	@Test
	void should_create_task_withOut_status() throws Exception{
		CreateTaskRequestDto dto = new CreateTaskRequestDto("[EDITAL]","Ocorrendo um retorno com a inconsistência");

		webTestClient.post()
				.uri("/tasks")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.body(Mono.just(dto), CreateTaskRequestDto.class)
				.exchange()
				.expectStatus().isCreated() // 3. Verify HTTP Status 201 Created
				.expectHeader().contentType(MediaType.APPLICATION_JSON) // 4. Verify Content-Type header
				.expectBody()  // 5. Verify the JSON response body
				.jsonPath("$.id").isNotEmpty();

	}

	@Test
	void should_create_task_with_status() throws Exception{
		CreateTaskRequestDto dto = new CreateTaskRequestDto("[EDITAL]",
				"Ocorrendo um retorno com a inconsistência",
				TaskStatus.PENDING);

		webTestClient.post()
				.uri("/tasks")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.body(Mono.just(dto), CreateTaskRequestDto.class)
				.exchange()
				.expectStatus().isCreated() // 3. Verify HTTP Status 201 Created
				.expectHeader().contentType(MediaType.APPLICATION_JSON) // 4. Verify Content-Type header
				.expectBody()  // 5. Verify the JSON response body
				.jsonPath("$.id").isNotEmpty();

	}


}

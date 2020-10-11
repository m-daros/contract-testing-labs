package mdaros.labs.spring.boot.contract.testing.service.client.service;

import mdaros.labs.spring.boot.contract.testing.service.client.ServiceClientApplication;
import mdaros.labs.spring.boot.contract.testing.service.client.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest ( classes = ServiceClientApplication.class )
@RunWith ( SpringRunner.class )
@AutoConfigureStubRunner ( ids = "mdaros.labs.spring.boot.contract.testing:service-provider:+:8080", stubsMode = StubRunnerProperties.StubsMode.LOCAL )
public class ClientServiceTest {

	@Autowired
	private ClientService service;

	@Test
	public void testFindBooks () throws Exception {

		// Invoke method to test
		Flux<Book> books = service.findBooks ();

		// Assertions
		StepVerifier.create ( books )
				.expectNextMatches ( book -> book.getId () != null && book.getPublishDate () != null )
				.expectNextMatches ( book -> book.getId () != null && book.getPublishDate () != null )
				.verifyComplete ();
	}

	@Test
	public void testFindBook () throws Exception {

		// Invoke method to test
		Mono<Book> book = service.findBook ( 1L );

		// Assertions
		StepVerifier.create ( book )
				.expectNextMatches ( b -> b.getId () != null && b.getPublishDate () != null )
				.verifyComplete ();
	}
}
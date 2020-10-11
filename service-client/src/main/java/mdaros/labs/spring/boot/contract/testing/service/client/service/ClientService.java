package mdaros.labs.spring.boot.contract.testing.service.client.service;

import mdaros.labs.spring.boot.contract.testing.service.client.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientService {

	@Autowired
	private WebClient webClient;

	public Flux<Book> findBooks () {

		return webClient.get ()
				.uri ( "/api/v1/books" )
				.header ( HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE )
				.retrieve ()
				.bodyToFlux ( Book.class );
	}

	public Mono<Book> findBook ( Long id ) {

		return webClient.get ()
				.uri ( "/api/v1/books/" + id )
				.header ( HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE )
				.retrieve ()
				.bodyToMono ( Book.class );
	}
}
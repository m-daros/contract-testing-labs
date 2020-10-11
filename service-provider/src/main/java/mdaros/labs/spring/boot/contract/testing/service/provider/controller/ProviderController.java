package mdaros.labs.spring.boot.contract.testing.service.provider.controller;

import mdaros.labs.spring.boot.contract.testing.service.provider.model.Book;
import mdaros.labs.spring.boot.contract.testing.service.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProviderController {

	@Autowired
	private ProviderService service;

	@GetMapping ( "/api/v1/books" )
	public Flux<Book> getBooks () {

		return service.findBooks ();
	}

	@GetMapping ( "/api/v1/books/{id}" )
	public Mono<Book> getBooks ( @PathVariable ( name = "id" ) Long id ) {

		return service.findBook ( id );
	}
}
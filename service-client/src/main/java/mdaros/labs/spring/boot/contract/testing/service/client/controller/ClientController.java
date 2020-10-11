package mdaros.labs.spring.boot.contract.testing.service.client.controller;

import mdaros.labs.spring.boot.contract.testing.service.client.model.Book;
import mdaros.labs.spring.boot.contract.testing.service.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class ClientController {

	@Autowired
	private ClientService service;

	@GetMapping ( "/api/v1/books" )
	public Flux<Book> getBooks () {

		return service.findBooks ();
	}
}
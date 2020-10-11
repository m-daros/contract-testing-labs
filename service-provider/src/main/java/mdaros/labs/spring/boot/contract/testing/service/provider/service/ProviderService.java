package mdaros.labs.spring.boot.contract.testing.service.provider.service;

import mdaros.labs.spring.boot.contract.testing.service.provider.model.Book;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class ProviderService {

	public Flux<Book> findBooks () {

		Book book1 = new Book ( 1L, LocalDateTime.now () );
		Book book2 = new Book ( 2L, LocalDateTime.now () );

		return Flux.fromIterable ( Arrays.asList ( book1, book2 ) );
	}

	public Mono<Book> findBook ( Long id ) {

		Book book1 = new Book ( id, LocalDateTime.now () );

		return Mono.just ( book1 );
	}
}
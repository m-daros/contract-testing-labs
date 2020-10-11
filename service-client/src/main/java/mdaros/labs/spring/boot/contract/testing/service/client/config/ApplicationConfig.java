package mdaros.labs.spring.boot.contract.testing.service.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ApplicationConfig {

	@Bean
	WebClient webCLient () {

		return WebClient.builder()
				.baseUrl ( "http://localhost:8080" )
				.build ();
	}
}
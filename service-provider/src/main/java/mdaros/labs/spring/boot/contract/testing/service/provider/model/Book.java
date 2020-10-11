package mdaros.labs.spring.boot.contract.testing.service.provider.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	private Long          id;
	private LocalDateTime publishDate;
}
package com.tp3.client;

import com.tp3.client.web.BookClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication {

	private final BookClient bookClient;

	public ClientApplication(BookClient bookClient) {
		this.bookClient = bookClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> bookClient.getOne();
	}
}

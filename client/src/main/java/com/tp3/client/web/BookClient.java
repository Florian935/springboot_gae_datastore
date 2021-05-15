package com.tp3.client.web;

import com.tp3.client.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import static java.util.Objects.requireNonNull;

@Configuration
public class BookClient {

    private static final Logger log = LoggerFactory.getLogger(BookClient.class);
    private final String SERVER_URL = "https://tp3-springboot.uc.r.appspot.com/books";
    private final RestTemplate restTemplate;

    public BookClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void getOne() {
        final Book responseEntity =
                restTemplate.getForObject(SERVER_URL, Book.class);
        assert responseEntity != null;
        log.info(requireNonNull(responseEntity.toString()));
    }
}

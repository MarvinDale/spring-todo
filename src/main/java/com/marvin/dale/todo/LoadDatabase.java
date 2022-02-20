package com.marvin.dale.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(TodoRepository repository) {
        return args -> {
            repository.save(new Todo("Go to the Gym", "Do 5 sets of pull-ups"));
        };
    }
}

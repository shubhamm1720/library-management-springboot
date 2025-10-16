package com.example.library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;

@SpringBootApplication
public class LibraryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(BookRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                System.out.println("🚀 Inserting demo books...");
                repo.save(new Book(null, "Java Basics", "Shubham Kumar"));
                repo.save(new Book(null, "Spring Boot Guide", "Ankit Sharma"));
                repo.save(new Book(null, "Data Structures", "Priya Singh"));
                System.out.println("✅ Demo books inserted: " + repo.count());
            }
        };
    }
}

package com.example.library.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;

@RestController
public class BookController {

    private final BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/books")
    public List<Book> getAll() {
        return repo.findAll();
    }

    @PostMapping("/books")
    public Book add(@RequestBody Book book) {
        return repo.save(book);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return repo.findById(id).map(b -> {
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

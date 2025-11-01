package com.cfs.BootP03BookApis.controller;

import com.cfs.BootP03BookApis.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    private Map<Long, Book> bookDB = new HashMap<>();

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(new ArrayList<>(bookDB.values()));
    }

    @PostMapping                   // @RequestBody: JACKSON lib json -> java obj
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        bookDB.put(book.getId(), book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        Book book = bookDB.get(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable long id, @RequestBody Book book) {
        Book existedBook = bookDB.get(id);
        if (existedBook == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        bookDB.put(existedBook.getId(), book);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @PatchMapping("/{id}/price")
    public ResponseEntity<Book> updateBookPrice(@PathVariable long id, @RequestBody double newPrice) {
        Book existedBook = bookDB.get(id);
        if (existedBook == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        existedBook.setPrice(newPrice);
        bookDB.put(existedBook.getId(), existedBook);
        return ResponseEntity.status(HttpStatus.OK).body(existedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable long id) {
        Book existedBook = bookDB.get(id);
        if (existedBook == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        bookDB.remove(id);
        return ResponseEntity.noContent().build();
    }

}

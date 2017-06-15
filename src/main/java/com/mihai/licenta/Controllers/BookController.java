package com.mihai.licenta.Controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mihai.licenta.Models.DBModels.Book;
import com.mihai.licenta.Models.DBModels.BookReview;
import com.mihai.licenta.Models.DBModels.Categories;
import com.mihai.licenta.Models.InternModels.StringResonse;
import com.mihai.licenta.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mihai on 07.06.2017.
 */
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    BookService bookService;


    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public ResponseEntity addBook(@RequestParam("title") String title,
                                  @RequestParam("author") String author,
                                  @RequestParam("description") String description,
                                  @RequestParam("categories") String sCategories,
                                  @RequestParam(value = "cover_photo", required = false) MultipartFile file) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setDescription(description);
        ObjectMapper mapper = new ObjectMapper();
        List<Categories> categories = new ArrayList<>();
        try {
            categories = mapper.readValue(sCategories, new TypeReference<List<Categories>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (bookService.registerBook(book, file, categories)) {
            return ResponseEntity.ok().body("Success");
        }

        return ResponseEntity.badRequest().body("Something went wrong");
    }


    @RequestMapping(value = "/addBookReview/{id}", method = RequestMethod.POST)
    public ResponseEntity addBookReview(@RequestBody BookReview bookReview, @PathVariable("id") Long bookID) {
        if (bookService.addBookReview(bookReview, bookID)) {
            return ResponseEntity.ok(new StringResonse("Success"));
        }
        return ResponseEntity.badRequest().body("Invalid book id");
    }


    @RequestMapping(value = "/getBookByID/{id}", method = RequestMethod.GET)
    public ResponseEntity getBookByID(@PathVariable("id") Long bookId) {
        Book book = bookService.findBookById(bookId);
        if (book != null) {
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.badRequest().body(new StringResonse("No book with such id"));
    }


    @RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
    public ResponseEntity getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
}

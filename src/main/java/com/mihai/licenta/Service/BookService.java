package com.mihai.licenta.Service;

import com.mihai.licenta.Models.DBModels.Book;
import com.mihai.licenta.Models.DBModels.BookReview;
import com.mihai.licenta.Models.DBModels.Categories;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by mihai on 02.06.2017.
 */

public interface BookService {

    Book findBookById(Long bid);

    Book findBookByName(String name);

    List<Book> getAllBooks();

    Book saveBook(Book book);

    Boolean registerBook(Book book,MultipartFile file, List<Categories> categoriesList);

    int setUpUserBookUrl(String url, Long bookId);

    Boolean addBookReview(BookReview bookReview, Long bookID);

}

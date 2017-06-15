package com.mihai.licenta.Impl;

import com.mihai.licenta.Models.DBModels.Book;
import com.mihai.licenta.Models.DBModels.BookReview;
import com.mihai.licenta.Models.DBModels.Categories;
import com.mihai.licenta.Models.DBModels.User;
import com.mihai.licenta.Repos.BooksRepository;
import com.mihai.licenta.Service.BookService;
import com.mihai.licenta.Utils.Urls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mihai on 02.06.2017.
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BooksRepository booksRepository;

    private static String UPLOADED_FOLDER = "/home/mihai/Documents/Licenta/Server/Resources/Images/Books/";

    @Override
    public Book findBookById(Long bid) {
        return booksRepository.findOne(bid);
    }

    @Override
    public Book findBookByName(String name) {
        return booksRepository.findByTitle(name);
    }

    @Override
    public List<Book> getAllBooks() {
       return booksRepository.findAll();
    }

    @Override
    public Boolean registerBook(Book book, MultipartFile file, List<Categories> categoriesList) {
        Book savedBook = this.saveBook(book);
        try {
            if (file != null) {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + savedBook.getbId() + "");
                Files.write(path, bytes);

                String url = Urls.BASE_URL + Urls.GET_COVER_URL + savedBook.getbId();
                setUpUserBookUrl(url, savedBook.getbId());
            }

            for (Categories c : categoriesList) {
                c.setBook(savedBook);
            }
            savedBook.setCategories(new HashSet<>(categoriesList));
            this.saveBook(savedBook);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public Book saveBook(Book book) {
        return booksRepository.save(book);
    }


    @Override
    public int setUpUserBookUrl(String url, Long bookId) {
        return booksRepository.updateBookCoverUrl(url, bookId);
    }

    @Override
    public Boolean addBookReview(BookReview bookReview, Long bookID) {
        Book book = findBookById(bookID);
        if (book != null) {
            bookReview.setBook(book);
            book.getBookReviews().add(bookReview);
            saveBook(book);
            return true;
        }
        return false;
    }

}

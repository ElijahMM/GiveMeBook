package com.mihai.licenta.Models.DBModels;

import javax.persistence.*;

/**
 * Created by mihai on 12.04.2017.
 */
@Entity
@IdClass(CategoriesPK.class)
public class Categories {
    private Integer catId;
    private String name;
    private Integer booksIdBook;
    private Books booksByBooksIdBook;

    @Id
    @Column(name = "catId", nullable = false)
    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "BOOKS_idBOOK", nullable = false)
    public Integer getBooksIdBook() {
        return booksIdBook;
    }

    public void setBooksIdBook(Integer booksIdBook) {
        this.booksIdBook = booksIdBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categories that = (Categories) o;

        if (catId != null ? !catId.equals(that.catId) : that.catId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (booksIdBook != null ? !booksIdBook.equals(that.booksIdBook) : that.booksIdBook != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = catId != null ? catId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (booksIdBook != null ? booksIdBook.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "BOOKS_idBOOK", referencedColumnName = "idBOOK", nullable = false)
    public Books getBooksByBooksIdBook() {
        return booksByBooksIdBook;
    }

    public void setBooksByBooksIdBook(Books booksByBooksIdBook) {
        this.booksByBooksIdBook = booksByBooksIdBook;
    }
}

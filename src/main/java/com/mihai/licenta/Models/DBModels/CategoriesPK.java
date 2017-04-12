package com.mihai.licenta.Models.DBModels;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mihai on 12.04.2017.
 */
public class CategoriesPK implements Serializable {
    private Integer catId;
    private Integer booksIdBook;

    @Column(name = "catId", nullable = false)
    @Id
    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    @Column(name = "BOOKS_idBOOK", nullable = false)
    @Id
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

        CategoriesPK that = (CategoriesPK) o;

        if (catId != null ? !catId.equals(that.catId) : that.catId != null) return false;
        if (booksIdBook != null ? !booksIdBook.equals(that.booksIdBook) : that.booksIdBook != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = catId != null ? catId.hashCode() : 0;
        result = 31 * result + (booksIdBook != null ? booksIdBook.hashCode() : 0);
        return result;
    }
}

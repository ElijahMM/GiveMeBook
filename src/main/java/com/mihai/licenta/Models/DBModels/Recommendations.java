package com.mihai.licenta.Models.DBModels;

import javax.persistence.*;

/**
 * Created by mihai on 12.04.2017.
 */
@Entity
@IdClass(RecommendationsPK.class)
public class Recommendations {
    private Integer idRecommendations;
    private Integer userUid;
    private Integer booksIdBook;
    private User userByUserUid;
    private Books booksByBooksIdBook;

    @Id
    @Column(name = "idRECOMMENDATIONS", nullable = false)
    public Integer getIdRecommendations() {
        return idRecommendations;
    }

    public void setIdRecommendations(Integer idRecommendations) {
        this.idRecommendations = idRecommendations;
    }

    @Id
    @Column(name = "USER_uid", nullable = false)
    public Integer getUserUid() {
        return userUid;
    }

    public void setUserUid(Integer userUid) {
        this.userUid = userUid;
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

        Recommendations that = (Recommendations) o;

        if (idRecommendations != null ? !idRecommendations.equals(that.idRecommendations) : that.idRecommendations != null)
            return false;
        if (userUid != null ? !userUid.equals(that.userUid) : that.userUid != null) return false;
        if (booksIdBook != null ? !booksIdBook.equals(that.booksIdBook) : that.booksIdBook != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRecommendations != null ? idRecommendations.hashCode() : 0;
        result = 31 * result + (userUid != null ? userUid.hashCode() : 0);
        result = 31 * result + (booksIdBook != null ? booksIdBook.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "USER_uid", referencedColumnName = "uid", nullable = false)
    public User getUserByUserUid() {
        return userByUserUid;
    }

    public void setUserByUserUid(User userByUserUid) {
        this.userByUserUid = userByUserUid;
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

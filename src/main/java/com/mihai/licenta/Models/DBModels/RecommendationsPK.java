package com.mihai.licenta.Models.DBModels;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mihai on 12.04.2017.
 */
public class RecommendationsPK implements Serializable {
    private Integer idRecommendations;
    private Integer userUid;
    private Integer booksIdBook;

    @Column(name = "idRECOMMENDATIONS", nullable = false)
    @Id
    public Integer getIdRecommendations() {
        return idRecommendations;
    }

    public void setIdRecommendations(Integer idRecommendations) {
        this.idRecommendations = idRecommendations;
    }

    @Column(name = "USER_uid", nullable = false)
    @Id
    public Integer getUserUid() {
        return userUid;
    }

    public void setUserUid(Integer userUid) {
        this.userUid = userUid;
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

        RecommendationsPK that = (RecommendationsPK) o;

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
}

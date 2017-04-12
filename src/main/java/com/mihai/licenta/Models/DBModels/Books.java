package com.mihai.licenta.Models.DBModels;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by mihai on 12.04.2017.
 */
@Entity
public class Books {
    private Integer idBook;
    private String title;
    private String autor;
    private String descr;
    private Collection<Categories> categoriesByIdBook;
    private Collection<Recommendations> recommendationssByIdBook;

    @Id
    @Column(name = "idBOOK", nullable = false)
    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "autor", nullable = false, length = 45)
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Basic
    @Column(name = "descr", nullable = false, length = 45)
    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        if (idBook != null ? !idBook.equals(books.idBook) : books.idBook != null) return false;
        if (title != null ? !title.equals(books.title) : books.title != null) return false;
        if (autor != null ? !autor.equals(books.autor) : books.autor != null) return false;
        if (descr != null ? !descr.equals(books.descr) : books.descr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBook != null ? idBook.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (autor != null ? autor.hashCode() : 0);
        result = 31 * result + (descr != null ? descr.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "booksByBooksIdBook")
    public Collection<Categories> getCategoriesByIdBook() {
        return categoriesByIdBook;
    }

    public void setCategoriesByIdBook(Collection<Categories> categoriesByIdBook) {
        this.categoriesByIdBook = categoriesByIdBook;
    }

    @OneToMany(mappedBy = "booksByBooksIdBook")
    public Collection<Recommendations> getRecommendationssByIdBook() {
        return recommendationssByIdBook;
    }

    public void setRecommendationssByIdBook(Collection<Recommendations> recommendationssByIdBook) {
        this.recommendationssByIdBook = recommendationssByIdBook;
    }
}

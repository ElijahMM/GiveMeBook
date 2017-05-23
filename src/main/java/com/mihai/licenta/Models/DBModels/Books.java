package com.mihai.licenta.Models.DBModels;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mihai on 12.05.2017.
 */
@Entity
@Table(name = "BOOKS")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bId;

    @Column
    private String name;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String description;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "book")
    private List<Categories> categories;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "book")
    private List<Recommendations> recommendations;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "book")
    private List<BookState> bookStates;


    public Long getbId() {
        return bId;
    }

    public void setbId(Long bId) {
        this.bId = bId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public List<Recommendations> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<Recommendations> recommendations) {
        this.recommendations = recommendations;
    }

    public List<BookState> getBookStates() {
        return bookStates;
    }

    public void setBookStates(List<BookState> bookStates) {
        this.bookStates = bookStates;
    }

}


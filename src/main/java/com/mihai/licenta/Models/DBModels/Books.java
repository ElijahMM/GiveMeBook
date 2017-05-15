package com.mihai.licenta.Models.DBModels;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mihai on 12.05.2017.
 */
@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long bId;

    @Column
    String name;

    @Column
    String title;

    @Column
    String author;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "book")
    List<Categories> categories;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "book")
    List<Recommendations> recommendations;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "book")
    List<BookState> bookStates;

}


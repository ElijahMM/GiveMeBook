package com.mihai.licenta.Models.DBModels;

import javax.persistence.*;

/**
 * Created by mihai on 12.05.2017.
 */

@Entity
public class Categories {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long cid;

    @Column
    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    Books book;

}

package com.mihai.licenta.Models.DBModels;

import javax.persistence.*;

/**
 * Created by mihai on 12.05.2017.
 */
@Entity
public class Recommendations {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long rid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    Books book;
}

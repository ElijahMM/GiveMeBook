package com.mihai.licenta.Models.DBModels;

import javax.persistence.*;

/**
 * Created by mihai on 12.05.2017.
 */
@Entity
public class Preferences {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long pid;

    @Column
    String pname;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

}

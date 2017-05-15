package com.mihai.licenta.Models.DBModels;

import javax.persistence.*;

/**
 * Created by mihai on 12.05.2017.
 */
@Entity
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long sid;


    @Column
    Boolean emailNotiffication;

    @Column
    Boolean pushNotiffication;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;
}

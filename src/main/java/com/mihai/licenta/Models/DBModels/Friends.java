package com.mihai.licenta.Models.DBModels;

import javax.persistence.*;

/**
 * Created by mihai on 12.05.2017.
 */
@Entity
public class Friends {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long fid;

    @Column
    String fbid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;
}

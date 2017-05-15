package com.mihai.licenta.Models.DBModels;

import javax.persistence.*;

/**
 * Created by mihai on 12.05.2017.
 */
@Entity
public class Interactions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long iId;

    @Column
    Integer type;

    @Column
    Integer refId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;
}

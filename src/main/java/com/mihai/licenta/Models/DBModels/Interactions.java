package com.mihai.licenta.Models.DBModels;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by mihai on 12.05.2017.
 */
@Entity
public class Interactions {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long iId;

    @Column
    Integer type;

    @Column
    Integer refId;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User user;
}

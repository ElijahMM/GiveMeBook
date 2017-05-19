package com.mihai.licenta.Models.DBModels;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by mihai on 12.05.2017.
 */
@Entity
public class Friends {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long fid;

    @Column
    String fbid;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User user;
}

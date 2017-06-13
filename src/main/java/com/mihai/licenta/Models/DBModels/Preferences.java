package com.mihai.licenta.Models.DBModels;

import javax.persistence.*;

/**
 * Created by mihai on 19.05.2017.
 */
@Entity
@Table(name = "PREFERENCES")
public class Preferences {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPreferences;

    @Column
    private String name;


    public Long getIdPreferences() {
        return idPreferences;
    }

    public void setIdPreferences(Long idPreferences) {
        this.idPreferences = idPreferences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

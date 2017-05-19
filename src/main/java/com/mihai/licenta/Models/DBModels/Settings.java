package com.mihai.licenta.Models.DBModels;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by mihai on 12.05.2017.
 */
@Entity
public class Settings {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long sid;


    @Column
    Boolean emailNotiffication;

    @Column
    Boolean pushNotiffication;

    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User user;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Boolean getEmailNotiffication() {
        return emailNotiffication;
    }

    public void setEmailNotiffication(Boolean emailNotiffication) {
        this.emailNotiffication = emailNotiffication;
    }

    public Boolean getPushNotiffication() {
        return pushNotiffication;
    }

    public void setPushNotiffication(Boolean pushNotiffication) {
        this.pushNotiffication = pushNotiffication;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

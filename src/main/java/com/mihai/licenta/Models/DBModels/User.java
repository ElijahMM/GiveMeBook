package com.mihai.licenta.Models.DBModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Created by mihai on 12.05.2017.
 */
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long uid;

    @Column
    String username;

    @JsonIgnore
    @Column
    String password;

    @Column
    String email;

    @Column
    Integer type;

    @Column
    String photoUrl;

    @Column
    String token;

    @Column
    Date createdAt;

    @Column
    Date updatedAt;

    @Column
    String fbID;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    Set<Preferences> preferences;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    Settings settings;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    Set<Interactions> interactions;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    Set<Friends> friends;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    Set<Recommendations> recommendations;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    Set<BookState> bookStates;


    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getFbID() {
        return fbID;
    }

    public void setFbID(String fbID) {
        this.fbID = fbID;
    }

    public Set<Preferences> getPreferences() {
        return preferences;
    }

    public void setPreferences(Set<Preferences> preferences) {
        this.preferences = preferences;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public Set<Interactions> getInteractions() {
        return interactions;
    }

    public void setInteractions(Set<Interactions> interactions) {
        this.interactions = interactions;
    }

    public Set<Friends> getFriends() {
        return friends;
    }

    public void setFriends(Set<Friends> friends) {
        this.friends = friends;
    }

    public Set<Recommendations> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(Set<Recommendations> recommendations) {
        this.recommendations = recommendations;
    }

    public Set<BookState> getBookStates() {
        return bookStates;
    }

    public void setBookStates(Set<BookState> bookStates) {
        this.bookStates = bookStates;
    }
}

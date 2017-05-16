package com.mihai.licenta.Models.DBModels;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    List<Preferences> preferences;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    List<Settings> settings;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    List<Interactions> interactions;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    List<Friends> friends;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    List<Recommendations> recommendations;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    List<BookState> bookStates;


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

    public List<Preferences> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Preferences> preferences) {
        this.preferences = preferences;
    }

    public List<Settings> getSettings() {
        return settings;
    }

    public void setSettings(List<Settings> settings) {
        this.settings = settings;
    }

    public List<Interactions> getInteractions() {
        return interactions;
    }

    public void setInteractions(List<Interactions> interactions) {
        this.interactions = interactions;
    }

    public List<Friends> getFriends() {
        return friends;
    }

    public void setFriends(List<Friends> friends) {
        this.friends = friends;
    }

    public List<Recommendations> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<Recommendations> recommendations) {
        this.recommendations = recommendations;
    }

    public List<BookState> getBookStates() {
        return bookStates;
    }

    public void setBookStates(List<BookState> bookStates) {
        this.bookStates = bookStates;
    }
}

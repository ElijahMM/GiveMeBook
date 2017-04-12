package com.mihai.licenta.Models.DBModels;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by mihai on 12.04.2017.
 */
@Entity
public class User {
    private Integer uid;
    private Integer type;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String photoUrl;
    private String token;
    private Date createdAt;
    private Date updateAt;
    private String fbId;
    private Collection<Friends> friendssByUid;
    private Collection<Interractions> interractionssByUid;
    private Collection<Preferences> preferencesByUid;
    private Collection<Recommendations> recommendationssByUid;
    private Collection<Settings> settingssByUid;

    @Id
    @Column(name = "uid", nullable = false)
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 20)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "photoUrl", nullable = false, length = 45)
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Basic
    @Column(name = "token", nullable = true, length = 100)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "created_at", nullable = false)
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "update_at", nullable = false)
    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Basic
    @Column(name = "fb_id", nullable = true, length = 45)
    public String getFbId() {
        return fbId;
    }

    public void setFbId(String fbId) {
        this.fbId = fbId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (uid != null ? !uid.equals(user.uid) : user.uid != null) return false;
        if (type != null ? !type.equals(user.type) : user.type != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (photoUrl != null ? !photoUrl.equals(user.photoUrl) : user.photoUrl != null) return false;
        if (token != null ? !token.equals(user.token) : user.token != null) return false;
        if (createdAt != null ? !createdAt.equals(user.createdAt) : user.createdAt != null) return false;
        if (updateAt != null ? !updateAt.equals(user.updateAt) : user.updateAt != null) return false;
        if (fbId != null ? !fbId.equals(user.fbId) : user.fbId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid != null ? uid.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (photoUrl != null ? photoUrl.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        result = 31 * result + (fbId != null ? fbId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserUid")
    public Collection<Friends> getFriendssByUid() {
        return friendssByUid;
    }

    public void setFriendssByUid(Collection<Friends> friendssByUid) {
        this.friendssByUid = friendssByUid;
    }

    @OneToMany(mappedBy = "userByUserUid")
    public Collection<Interractions> getInterractionssByUid() {
        return interractionssByUid;
    }

    public void setInterractionssByUid(Collection<Interractions> interractionssByUid) {
        this.interractionssByUid = interractionssByUid;
    }

    @OneToMany(mappedBy = "userByUserUid")
    public Collection<Preferences> getPreferencesByUid() {
        return preferencesByUid;
    }

    public void setPreferencesByUid(Collection<Preferences> preferencesByUid) {
        this.preferencesByUid = preferencesByUid;
    }

    @OneToMany(mappedBy = "userByUserUid")
    public Collection<Recommendations> getRecommendationssByUid() {
        return recommendationssByUid;
    }

    public void setRecommendationssByUid(Collection<Recommendations> recommendationssByUid) {
        this.recommendationssByUid = recommendationssByUid;
    }

    @OneToMany(mappedBy = "userByUserUid")
    public Collection<Settings> getSettingssByUid() {
        return settingssByUid;
    }

    public void setSettingssByUid(Collection<Settings> settingssByUid) {
        this.settingssByUid = settingssByUid;
    }
}

package com.mihai.licenta.Models.DBModels;

import javax.persistence.*;

/**
 * Created by mihai on 12.04.2017.
 */
@Entity
@IdClass(PreferencesPK.class)
public class Preferences {
    private Integer prefId;
    private String name;
    private Integer userUid;
    private User userByUserUid;

    @Id
    @Column(name = "prefId", nullable = false)
    public Integer getPrefId() {
        return prefId;
    }

    public void setPrefId(Integer prefId) {
        this.prefId = prefId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "USER_uid", nullable = false)
    public Integer getUserUid() {
        return userUid;
    }

    public void setUserUid(Integer userUid) {
        this.userUid = userUid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Preferences that = (Preferences) o;

        if (prefId != null ? !prefId.equals(that.prefId) : that.prefId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (userUid != null ? !userUid.equals(that.userUid) : that.userUid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prefId != null ? prefId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (userUid != null ? userUid.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "USER_uid", referencedColumnName = "uid", nullable = false)
    public User getUserByUserUid() {
        return userByUserUid;
    }

    public void setUserByUserUid(User userByUserUid) {
        this.userByUserUid = userByUserUid;
    }
}

package com.mihai.licenta.Models.DBModels;

import javax.persistence.*;

/**
 * Created by mihai on 12.04.2017.
 */
@Entity
@IdClass(InterractionsPK.class)
public class Interractions {
    private Integer idInterractions;
    private Integer uid;
    private Integer type;
    private Integer userUid;
    private User userByUserUid;

    @Id
    @Column(name = "idINTERRACTIONS", nullable = false)
    public Integer getIdInterractions() {
        return idInterractions;
    }

    public void setIdInterractions(Integer idInterractions) {
        this.idInterractions = idInterractions;
    }

    @Basic
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

        Interractions that = (Interractions) o;

        if (idInterractions != null ? !idInterractions.equals(that.idInterractions) : that.idInterractions != null)
            return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (userUid != null ? !userUid.equals(that.userUid) : that.userUid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idInterractions != null ? idInterractions.hashCode() : 0;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
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

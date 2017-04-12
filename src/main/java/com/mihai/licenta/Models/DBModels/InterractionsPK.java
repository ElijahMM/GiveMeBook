package com.mihai.licenta.Models.DBModels;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mihai on 12.04.2017.
 */
public class InterractionsPK implements Serializable {
    private Integer idInterractions;
    private Integer userUid;

    @Column(name = "idINTERRACTIONS", nullable = false)
    @Id
    public Integer getIdInterractions() {
        return idInterractions;
    }

    public void setIdInterractions(Integer idInterractions) {
        this.idInterractions = idInterractions;
    }

    @Column(name = "USER_uid", nullable = false)
    @Id
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

        InterractionsPK that = (InterractionsPK) o;

        if (idInterractions != null ? !idInterractions.equals(that.idInterractions) : that.idInterractions != null)
            return false;
        if (userUid != null ? !userUid.equals(that.userUid) : that.userUid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idInterractions != null ? idInterractions.hashCode() : 0;
        result = 31 * result + (userUid != null ? userUid.hashCode() : 0);
        return result;
    }
}

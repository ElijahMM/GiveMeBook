package com.mihai.licenta.Models.DBModels;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mihai on 12.04.2017.
 */
public class PreferencesPK implements Serializable {
    private Integer prefId;
    private Integer userUid;

    @Column(name = "prefId", nullable = false)
    @Id
    public Integer getPrefId() {
        return prefId;
    }

    public void setPrefId(Integer prefId) {
        this.prefId = prefId;
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

        PreferencesPK that = (PreferencesPK) o;

        if (prefId != null ? !prefId.equals(that.prefId) : that.prefId != null) return false;
        if (userUid != null ? !userUid.equals(that.userUid) : that.userUid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prefId != null ? prefId.hashCode() : 0;
        result = 31 * result + (userUid != null ? userUid.hashCode() : 0);
        return result;
    }
}

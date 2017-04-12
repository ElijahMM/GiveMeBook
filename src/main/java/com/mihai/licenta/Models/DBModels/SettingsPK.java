package com.mihai.licenta.Models.DBModels;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mihai on 12.04.2017.
 */
public class SettingsPK implements Serializable {
    private Integer sid;
    private Integer userUid;

    @Column(name = "sid", nullable = false)
    @Id
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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

        SettingsPK that = (SettingsPK) o;

        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (userUid != null ? !userUid.equals(that.userUid) : that.userUid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (userUid != null ? userUid.hashCode() : 0);
        return result;
    }
}

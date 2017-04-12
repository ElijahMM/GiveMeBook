package com.mihai.licenta.Models.DBModels;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mihai on 12.04.2017.
 */
public class FriendsPK implements Serializable {
    private Integer pid;
    private Integer userUid;

    @Column(name = "pid", nullable = false)
    @Id
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

        FriendsPK friendsPK = (FriendsPK) o;

        if (pid != null ? !pid.equals(friendsPK.pid) : friendsPK.pid != null) return false;
        if (userUid != null ? !userUid.equals(friendsPK.userUid) : friendsPK.userUid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pid != null ? pid.hashCode() : 0;
        result = 31 * result + (userUid != null ? userUid.hashCode() : 0);
        return result;
    }
}

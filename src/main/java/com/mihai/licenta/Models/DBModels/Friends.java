package com.mihai.licenta.Models.DBModels;

import javax.persistence.*;

/**
 * Created by mihai on 12.04.2017.
 */
@Entity
@IdClass(FriendsPK.class)
public class Friends {
    private Integer pid;
    private String fbId;
    private Integer userUid;
    private User userByUserUid;

    @Id
    @Column(name = "pid", nullable = false)
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "fb_id", nullable = false, length = 45)
    public String getFbId() {
        return fbId;
    }

    public void setFbId(String fbId) {
        this.fbId = fbId;
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

        Friends friends = (Friends) o;

        if (pid != null ? !pid.equals(friends.pid) : friends.pid != null) return false;
        if (fbId != null ? !fbId.equals(friends.fbId) : friends.fbId != null) return false;
        if (userUid != null ? !userUid.equals(friends.userUid) : friends.userUid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pid != null ? pid.hashCode() : 0;
        result = 31 * result + (fbId != null ? fbId.hashCode() : 0);
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

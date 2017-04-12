package com.mihai.licenta.Models.DBModels;

import javax.persistence.*;

/**
 * Created by mihai on 12.04.2017.
 */
@Entity
@IdClass(SettingsPK.class)
public class Settings {
    private Integer sid;
    private Byte emailNotification;
    private Byte pushNotification;
    private Integer userUid;
    private User userByUserUid;

    @Id
    @Column(name = "sid", nullable = false)
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "email_notification", nullable = false)
    public Byte getEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(Byte emailNotification) {
        this.emailNotification = emailNotification;
    }

    @Basic
    @Column(name = "push_notification", nullable = false)
    public Byte getPushNotification() {
        return pushNotification;
    }

    public void setPushNotification(Byte pushNotification) {
        this.pushNotification = pushNotification;
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

        Settings settings = (Settings) o;

        if (sid != null ? !sid.equals(settings.sid) : settings.sid != null) return false;
        if (emailNotification != null ? !emailNotification.equals(settings.emailNotification) : settings.emailNotification != null)
            return false;
        if (pushNotification != null ? !pushNotification.equals(settings.pushNotification) : settings.pushNotification != null)
            return false;
        if (userUid != null ? !userUid.equals(settings.userUid) : settings.userUid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (emailNotification != null ? emailNotification.hashCode() : 0);
        result = 31 * result + (pushNotification != null ? pushNotification.hashCode() : 0);
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

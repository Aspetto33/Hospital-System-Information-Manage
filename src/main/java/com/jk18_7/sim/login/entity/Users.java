package com.jk18_7.sim.login.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
    private int uId;
    private String uName;
    private String uPwd;
    private String uEmail;
    private String salt;

    @Id
    @Column(name = "u_id")
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "u_name")
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Basic
    @Column(name = "u_pwd")
    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    @Basic
    @Column(name = "u_email")
    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    @Basic
    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (uId != users.uId) return false;
        if (uName != null ? !uName.equals(users.uName) : users.uName != null) return false;
        if (uPwd != null ? !uPwd.equals(users.uPwd) : users.uPwd != null) return false;
        if (uEmail != null ? !uEmail.equals(users.uEmail) : users.uEmail != null) return false;
        if (salt != null ? !salt.equals(users.salt) : users.salt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uId;
        result = 31 * result + (uName != null ? uName.hashCode() : 0);
        result = 31 * result + (uPwd != null ? uPwd.hashCode() : 0);
        result = 31 * result + (uEmail != null ? uEmail.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        return result;
    }
}

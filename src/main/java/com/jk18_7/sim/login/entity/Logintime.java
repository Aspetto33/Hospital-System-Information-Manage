package com.jk18_7.sim.login.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Logintime {
    private int uId;
    private Date lTime;
    private Integer lCount;

    @Id
    @Column(name = "u_id")
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "l_time")
    public Date getlTime() {
        return lTime;
    }

    public void setlTime(Date lTime) {
        this.lTime = lTime;
    }

    @Basic
    @Column(name = "l_count")
    public Integer getlCount() {
        return lCount;
    }

    public void setlCount(Integer lCount) {
        this.lCount = lCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Logintime logintime = (Logintime) o;

        if (uId != logintime.uId) return false;
        if (lTime != null ? !lTime.equals(logintime.lTime) : logintime.lTime != null) return false;
        if (lCount != null ? !lCount.equals(logintime.lCount) : logintime.lCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uId;
        result = 31 * result + (lTime != null ? lTime.hashCode() : 0);
        result = 31 * result + (lCount != null ? lCount.hashCode() : 0);
        return result;
    }
}

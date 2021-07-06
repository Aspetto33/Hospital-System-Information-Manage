package com.jk18_7.sim.authority.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_role", schema = "jk18_7", catalog = "")
public class UserRole {
    private long id;
    private Long uId;
    private Long rId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "u_id")
    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "r_id")
    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (id != userRole.id) return false;
        if (uId != null ? !uId.equals(userRole.uId) : userRole.uId != null) return false;
        if (rId != null ? !rId.equals(userRole.rId) : userRole.rId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (uId != null ? uId.hashCode() : 0);
        result = 31 * result + (rId != null ? rId.hashCode() : 0);
        return result;
    }
}

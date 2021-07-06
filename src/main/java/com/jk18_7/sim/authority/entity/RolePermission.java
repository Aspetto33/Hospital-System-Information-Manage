package com.jk18_7.sim.authority.entity;

import javax.persistence.*;

@Entity
@Table(name = "role_permission", schema = "jk18_7", catalog = "")
public class RolePermission {
    private long id;
    private Long rId;
    private Long pId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "r_id")
    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    @Basic
    @Column(name = "p_id")
    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolePermission that = (RolePermission) o;

        if (id != that.id) return false;
        if (rId != null ? !rId.equals(that.rId) : that.rId != null) return false;
        if (pId != null ? !pId.equals(that.pId) : that.pId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (rId != null ? rId.hashCode() : 0);
        result = 31 * result + (pId != null ? pId.hashCode() : 0);
        return result;
    }
}

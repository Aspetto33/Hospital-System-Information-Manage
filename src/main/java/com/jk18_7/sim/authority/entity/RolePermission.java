package com.jk18_7.sim.authority.entity;

import javax.persistence.*;

@Entity
@Table(name = "role_permission", schema = "jk18_7", catalog = "")
public class RolePermission {
    private int id;
    private Integer rId;
    private Integer pId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "r_id")
    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    @Basic
    @Column(name = "p_id")
    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
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
        int result = id;
        result = 31 * result + (rId != null ? rId.hashCode() : 0);
        result = 31 * result + (pId != null ? pId.hashCode() : 0);
        return result;
    }
}

package com.jk18_7.sim.authority.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
    private int rId;
    private String rName;
    private String desc;

    @Id
    @Column(name = "r_id")
    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    @Basic
    @Column(name = "r_name")
    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    @Basic
    @Column(name = "desc_")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (rId != role.rId) return false;
        if (rName != null ? !rName.equals(role.rName) : role.rName != null) return false;
        if (desc != null ? !desc.equals(role.desc) : role.desc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rId;
        result = 31 * result + (rName != null ? rName.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        return result;
    }
}

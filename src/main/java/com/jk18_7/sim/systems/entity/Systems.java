package com.jk18_7.sim.systems.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Systems {
    private int sId;
    private String sName;
    private String sVersion;

    @Id
    @Column(name = "s_id")
    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    @Basic
    @Column(name = "s_name")
    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Basic
    @Column(name = "s_version")
    public String getsVersion() {
        return sVersion;
    }

    public void setsVersion(String sVersion) {
        this.sVersion = sVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Systems systems = (Systems) o;

        if (sId != systems.sId) return false;
        if (sName != null ? !sName.equals(systems.sName) : systems.sName != null) return false;
        if (sVersion != null ? !sVersion.equals(systems.sVersion) : systems.sVersion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sId;
        result = 31 * result + (sName != null ? sName.hashCode() : 0);
        result = 31 * result + (sVersion != null ? sVersion.hashCode() : 0);
        return result;
    }
}

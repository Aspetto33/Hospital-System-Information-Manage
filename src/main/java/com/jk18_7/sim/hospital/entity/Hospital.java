package com.jk18_7.sim.hospital.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hospital {
    private int hId;
    private String deCount;
    private String hArea;
    private String dCount;
    private String hTime;

    @Id
    @Column(name = "h_id")
    public int gethId() {
        return hId;
    }

    public void sethId(int hId) {
        this.hId = hId;
    }

    @Basic
    @Column(name = "de_count")
    public String getDeCount() {
        return deCount;
    }

    public void setDeCount(String deCount) {
        this.deCount = deCount;
    }

    @Basic
    @Column(name = "h_area")
    public String gethArea() {
        return hArea;
    }

    public void sethArea(String hArea) {
        this.hArea = hArea;
    }

    @Basic
    @Column(name = "d_count")
    public String getdCount() {
        return dCount;
    }

    public void setdCount(String dCount) {
        this.dCount = dCount;
    }

    @Basic
    @Column(name = "h_time")
    public String gethTime() {
        return hTime;
    }

    public void sethTime(String hTime) {
        this.hTime = hTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hospital hospital = (Hospital) o;

        if (hId != hospital.hId) return false;
        if (deCount != null ? !deCount.equals(hospital.deCount) : hospital.deCount != null) return false;
        if (hArea != null ? !hArea.equals(hospital.hArea) : hospital.hArea != null) return false;
        if (dCount != null ? !dCount.equals(hospital.dCount) : hospital.dCount != null) return false;
        if (hTime != null ? !hTime.equals(hospital.hTime) : hospital.hTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hId;
        result = 31 * result + (deCount != null ? deCount.hashCode() : 0);
        result = 31 * result + (hArea != null ? hArea.hashCode() : 0);
        result = 31 * result + (dCount != null ? dCount.hashCode() : 0);
        result = 31 * result + (hTime != null ? hTime.hashCode() : 0);
        return result;
    }
}

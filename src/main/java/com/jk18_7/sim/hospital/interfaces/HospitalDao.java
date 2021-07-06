package com.jk18_7.sim.hospital.interfaces;

import com.jk18_7.sim.hospital.entity.Hospital;

import java.util.List;

public interface HospitalDao {
    List<Hospital> getHospital();
    void addHospital(Hospital hospital);
    void deleteHospital(int hId);
}

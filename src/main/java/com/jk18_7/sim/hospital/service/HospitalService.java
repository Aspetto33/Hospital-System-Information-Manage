package com.jk18_7.sim.hospital.service;

import com.jk18_7.sim.hospital.entity.Hospital;

import java.util.List;

public interface HospitalService {
    List<Hospital> getHospital();
    void addHospital(Hospital hospital);
    void deleteHospital(int hId);

}

package com.jk18_7.sim.hospital.service.impl;

import com.jk18_7.sim.hospital.entity.Hospital;
import com.jk18_7.sim.hospital.interfaces.HospitalDao;
import com.jk18_7.sim.hospital.service.HospitalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("hospitalService")
public class HospitalServiceImpl implements HospitalService {
    @Resource
    private HospitalDao hospitalDao;
    @Override
    public List<Hospital> getHospital() {
        return hospitalDao.getHospital() ;
    }

    @Override
    public void addHospital(Hospital hospital) {
        hospitalDao.addHospital(hospital);
    }

    @Override
    public void deleteHospital(int hId) {
        hospitalDao.deleteHospital(hId);
    }


}

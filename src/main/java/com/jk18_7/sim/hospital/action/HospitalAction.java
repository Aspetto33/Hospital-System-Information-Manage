package com.jk18_7.sim.hospital.action;

import com.jk18_7.sim.hospital.entity.Hospital;
import com.jk18_7.sim.hospital.service.HospitalService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;
import java.util.List;

public class HospitalAction extends ActionSupport {
    @Resource
    private HospitalService hospitalService;
    private Hospital hospital;
    private int hId;

    public String getHospitals(){
        List<Hospital> hospitalList = hospitalService.getHospital();
        ActionContext actionContext = ActionContext.getContext();
        actionContext.put("hospitalList",hospitalList);
        return "getHospitals";
    }
    public String addHospital(){
        hospitalService.addHospital(hospital);
        return "addHospital";
    }
    public String deleteHospital(){
        hospitalService.deleteHospital(hId);
        return "deleteHospital";
    }
    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public int gethId() {
        return hId;
    }

    public void sethId(int hId) {
        this.hId = hId;
    }
}
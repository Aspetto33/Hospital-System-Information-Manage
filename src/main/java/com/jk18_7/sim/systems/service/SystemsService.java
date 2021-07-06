package com.jk18_7.sim.systems.service;

import com.jk18_7.sim.systems.entity.Systems;

import java.util.List;

public interface SystemsService {
    List<Systems> getSystems();
    void addSystems(Systems systems);
    void updateSystems(Systems systems);

}

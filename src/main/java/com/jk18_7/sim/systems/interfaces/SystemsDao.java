package com.jk18_7.sim.systems.interfaces;

import com.jk18_7.sim.systems.entity.Systems;

import java.util.List;

public interface SystemsDao {
    List<Systems> getSystems();
    void addSystems(Systems systems);
    void updateSystems(Systems systems);

}

package com.jk18_7.sim.systems.service.impl;

import com.jk18_7.sim.systems.entity.Systems;
import com.jk18_7.sim.systems.interfaces.SystemsDao;
import com.jk18_7.sim.systems.service.SystemsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("systemsService")
public class SystemsServiceImpl implements SystemsService {
    @Resource
    private SystemsDao systemsDao;
    @Override
    public List<Systems> getSystems() {
        return systemsDao.getSystems();
    }

    @Override
    public void addSystems(Systems systems) {
        systemsDao.addSystems(systems);
    }

    @Override
    public void updateSystems(Systems systems) {
        systemsDao.updateSystems(systems);
    }
}

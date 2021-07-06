package com.jk18_7.sim.systems.action;

import com.jk18_7.sim.systems.entity.Systems;
import com.jk18_7.sim.systems.service.SystemsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;
import java.util.List;

public class SystemsAction extends ActionSupport {
    @Resource
    private SystemsService systemsService;
    private Systems systems;

    public String getSystem(){
        List<Systems> systemsList = systemsService.getSystems();
        ActionContext actionContext = ActionContext.getContext();
        actionContext.put("systemsList",systemsList);
        return "getSystem";
    }

    public String addSystem(){
        Systems systems = new Systems();
        systemsService.addSystems(systems);
        return "addSystem";
    }
    public String updateSystem(){
        systemsService.updateSystems(systems);
        return "updateSystem";
    }

    public Systems getSystems() {
        return systems;
    }

    public void setSystems(Systems systems) {
        this.systems = systems;
    }
}

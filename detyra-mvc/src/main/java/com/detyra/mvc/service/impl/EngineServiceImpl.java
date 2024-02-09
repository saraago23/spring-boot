package com.detyra.mvc.service.impl;

import com.detyra.mvc.dto.Engine;
import com.detyra.mvc.repository.EngineDAO;
import com.detyra.mvc.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EngineServiceImpl implements EngineService {
    @Autowired
    private EngineDAO engineDAO;

    @Override
    public List<Engine> getEngines() {
        return engineDAO.getEngines();
    }

    @Override
    public Engine getEngineById(Integer id) {
        return engineDAO.getEngineById(id);
    }

    @Override
    public Integer insertEngine(Engine engine) {
        return engineDAO.insertEngine(engine);
    }

    @Override
    public Boolean updateEngine(Engine engine) {
        return engineDAO.updateEngine(engine);
    }

    @Override
    public Boolean deleteEngine(Integer id) {
        return engineDAO.deleteEngine(id);
    }
}

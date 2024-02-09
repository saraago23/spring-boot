package com.detyra.mvc.service;

import com.detyra.mvc.dto.Engine;

import java.util.List;

public interface EngineService {
    List<Engine> getEngines();
    Engine getEngineById(Integer id);
    Integer insertEngine(Engine engine);
    Boolean updateEngine(Engine engine);
    Boolean deleteEngine(Integer id);
}

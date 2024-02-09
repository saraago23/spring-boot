package com.detyra.mvc.repository;

import com.detyra.mvc.dto.Engine;

import java.util.List;

public interface EngineDAO {
    List<Engine> getEngines();
    Engine getEngineById(Integer id);
    Integer insertEngine(Engine engine);
    Boolean updateEngine(Engine engine);
    Boolean deleteEngine(Integer id);
}

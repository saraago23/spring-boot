package com.detyra.mvc.repository;

import com.detyra.mvc.dto.Wheel;

import java.util.List;

public interface WheelDAO {
    List<Wheel> getWheels();
   Wheel getWheelById(Integer id);
    Integer insertWheel(Wheel wheel);
    Boolean updateWheel(Wheel wheel);
    Boolean deleteWheel(Integer id);
}

package com.detyra.mvc.service.impl;

import com.detyra.mvc.dto.Wheel;
import com.detyra.mvc.repository.WheelDAO;
import com.detyra.mvc.service.WheelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WheelServiceImpl implements WheelService {
    @Autowired
    private WheelDAO wheelDAO;

    @Override
    public List<Wheel> getWheels() {
        return wheelDAO.getWheels();
    }

    @Override
    public Wheel getWheelById(Integer id) {
        return wheelDAO.getWheelById(id);
    }

    @Override
    public Integer insertWheel(Wheel wheel) {
        return wheelDAO.insertWheel(wheel);
    }

    @Override
    public Boolean updateWheel(Wheel wheel) {
        return wheelDAO.updateWheel(wheel);
    }

    @Override
    public Boolean deleteWheel(Integer id) {
        return wheelDAO.deleteWheel(id);
    }
}

package com.akademia.detyra1;

import org.springframework.stereotype.Component;

@Component
public class Kub implements Shape3D {
    private ShapeEnum type= ShapeEnum.KUB;
    @Override
    public boolean isShapeTypeSupported(String shapeType) {
        return type.name().equals(shapeType.toUpperCase());
    }

    @Override
    public Double calculateVolume(Double... param) {
        return param[0]*param[0]*param[0];
    }

    @Override
    public Double calculateArea(Double... param) {
        return 6*(param[0]*param[0]);
    }
}

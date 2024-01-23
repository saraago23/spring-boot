package com.akademia.detyra1;

import org.springframework.stereotype.Component;

@Component
public class Cilinder implements Shape3D{

    private ShapeEnum type=ShapeEnum.CILINDER;
    @Override
    public boolean isShapeTypeSupported(String shapeType) {
        return type.name().equals(shapeType.toUpperCase());
    }

    @Override
    public Double calculateVolume(Double... param) {
        return Math.PI*param[0]*param[0]*param[1];
    }

    @Override
    public Double calculateArea(Double... param) {
        return 2*Math.PI*param[0]*(param[0]+param[1]);
    }
}

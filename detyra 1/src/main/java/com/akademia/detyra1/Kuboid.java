package com.akademia.detyra1;

import org.springframework.stereotype.Component;

@Component
public class Kuboid implements Shape3D{
    private ShapeEnum type= ShapeEnum.KUBOID;
    @Override
    public boolean isShapeTypeSupported(String shapeType) {
        return type.name().equals(shapeType.toUpperCase());
    }

    @Override
    public Double calculateVolume(Double... param) {
        return param[0]*param[1]*param[2];
    }

    @Override
    public Double calculateArea(Double... param) {
        return 2*((param[0]*param[2])+(param[1]*param[2])+(param[0]*param[1]));
    }
}

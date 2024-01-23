package com.akademia.detyra1;

import org.springframework.stereotype.Component;

@Component
public class Trapez implements Shape2D{
    private ShapeEnum type= ShapeEnum.TRAPEZ;
    @Override
    public boolean isShapeTypeSupported(String shapeType) {
        return type.name().equals(shapeType.toUpperCase());
    }

    @Override
    public Double calculatePerimeter(Double... param) {
        return param[0]+param[1]+param[2]+param[3];
    }

    @Override
    public Double calculateArea(Double... param) {
        return ((param[0]+param[1]) * param[2])/2;
    }
}

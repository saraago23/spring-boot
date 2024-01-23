package com.akademia.detyra1;

import org.springframework.stereotype.Component;

@Component
public class Drejtkendesh implements Shape2D {

    private ShapeEnum type=ShapeEnum.DREJTKENDESH;
    @Override
    public boolean isShapeTypeSupported(String shapeType) {
        return type.name().equals(shapeType.toUpperCase());
    }

    @Override
    public Double calculatePerimeter(Double... param) {
        return 2*param[0]+ 2*param[1];
    }

    @Override
    public Double calculateArea(Double... param) {
        return param[0]*param[1];
    }
}

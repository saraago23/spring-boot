package com.akademia.detyra1;

import org.springframework.stereotype.Component;

@Component
public class Trekendesh implements Shape2D {

    private ShapeEnum type = ShapeEnum.TREKENDESH;

    @Override
    public boolean isShapeTypeSupported(String shapeType) {
        return type.name().equals(shapeType.toUpperCase());
    }

    @Override
    public Double calculatePerimeter(Double... param) {
        return param[0] + param[1] + param[2];
    }

    @Override
    public Double calculateArea(Double... param) {
        return param[0] * param[1] / 2;
    }


}

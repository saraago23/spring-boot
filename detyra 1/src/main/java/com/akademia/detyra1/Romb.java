package com.akademia.detyra1;

import org.springframework.stereotype.Component;

@Component
public class Romb implements Shape2D {
    private ShapeEnum type = ShapeEnum.ROMB;

    @Override
    public boolean isShapeTypeSupported(String shapeType) {
        return type.name().equals(shapeType.toUpperCase());
    }

    @Override
    public Double calculatePerimeter(Double... param) {
        return 4 * param[0];
    }

    @Override
    public Double calculateArea(Double... param) {
        return (param[0] * param[1]) / 2;
    }
}

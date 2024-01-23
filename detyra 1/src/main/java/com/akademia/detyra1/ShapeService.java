package com.akademia.detyra1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShapeService {

    @Autowired
    private List<Shape2D> shape2DS;

    @Autowired
    private List<Shape3D> shape3DS;


    public Double calculateArea2D(String tipi, Double... param) {
        return shape2DS.stream()
                .filter(s -> s.isShapeTypeSupported(tipi))
                .findFirst().orElseThrow(() -> new RuntimeException("Shape not supported"))
                .calculateArea(param);
    }

    public Double calculatePerimeter2D(String tipi, Double... param) {
        return shape2DS.stream()
                .filter(s -> s.isShapeTypeSupported(tipi))
                .findFirst().orElseThrow(() -> new RuntimeException("Shape not supported"))
                .calculatePerimeter(param);
    }

    public Double calculateArea3D(String tipi, Double... param) {
        return shape3DS.stream()
                .filter(s -> s.isShapeTypeSupported(tipi))
                .findFirst().orElseThrow(() -> new RuntimeException("Shape not supported"))
                .calculateArea(param);
    }

    public Double calculateVolume3D(String tipi, Double... param) {

        return shape3DS.stream()
                .filter(s -> s.isShapeTypeSupported(tipi))
                .findFirst().orElseThrow(() -> new RuntimeException("Shape not supported"))
                .calculateVolume(param);
    }

}

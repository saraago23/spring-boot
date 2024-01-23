package com.akademia.detyra1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ShapeDemo implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(ShapeDemo.class);

    @Autowired
    private ShapeService shapeService;

    @Override
    public void run(String... args) {

        String forma = "kub";
        Double volume=shapeService.calculateVolume3D(forma, 5.0);
        logger.info("Volumi i {} me brinje {} eshte {} ",forma,5.0,volume);

    }
}

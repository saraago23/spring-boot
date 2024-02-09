package com.detyra.mvc.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Car {
    private Integer id;
    private String carName;
    private Integer fromYear;
    private Integer toYear;
    private Wheel wheelsId;
    private Engine engineId;


}

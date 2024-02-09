package com.detyra.mvc.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Wheel {
    private Integer id;
    private String size;
    private String wheelType;
}

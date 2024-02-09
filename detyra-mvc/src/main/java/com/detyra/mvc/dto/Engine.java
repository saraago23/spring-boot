package com.detyra.mvc.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Engine {
    private Integer id;
    private Integer enginePower;
    private String engineType;
}

package com.detyra.mvc.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Engine {
    private Integer id;
    @NotNull(message = "This field cannot be left empty")
    private Integer enginePower;
    @NotEmpty(message = "This field cannot be left empty")
    private String engineType;
}

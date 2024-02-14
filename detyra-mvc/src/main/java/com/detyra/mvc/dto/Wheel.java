package com.detyra.mvc.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Wheel {
    private Integer id;
    @NotEmpty(message = "This field cannot be left empty")

    private String size;
    @NotEmpty(message = "This field cannot be left empty")

    private String wheelType;
}

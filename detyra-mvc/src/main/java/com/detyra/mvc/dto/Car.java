package com.detyra.mvc.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Car {
    private Integer id;
    @NotEmpty(message = "This field cannot be empty")
    private String carName;
    @Range(min = 1000, max = 9999, message = "Year must be of 4 digits")
    @NotNull
    private Integer fromYear;
    @Range(min = 1000, max = 9999, message = "Year must be of 4 digits")
    @NotNull
    private Integer toYear;

    private Wheel wheelsId;

    private Engine engineId;


}

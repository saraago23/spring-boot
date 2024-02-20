package com.akademia.detyrajpa.entity;

import com.akademia.detyrajpa.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name="employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_no")
    private Integer empNo;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate hireDate;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + empNo +
                ", birth Date=" + birthDate +
                ", first Name='" + firstName + '\'' +
                ", last Name='" + lastName + '\'' +
                ", gender=" + gender +
                ", hire Date=" + hireDate +
                '}';
    }
}

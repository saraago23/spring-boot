package com.akademia.detyrajpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name="departments")
public class DepartmentEntity {
    @Id
    @Column(name = "dept_no")
    private String deptNo;
    @Column(name = "dept_name")
    private String deptName;

    @Override
    public String toString() {
        return "Department{" +
                "department number ='" + deptNo + '\'' +
                ", department name= '" + deptName + '\'' +
                '}';
    }
}

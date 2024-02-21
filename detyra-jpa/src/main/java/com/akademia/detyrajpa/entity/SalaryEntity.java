package com.akademia.detyrajpa.entity;

import com.akademia.detyrajpa.entity.compositeprimarykeys.SalaryEntityId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salaries")
public class SalaryEntity {
    @EmbeddedId
    private SalaryEntityId salaryEntityId;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("empNo")
    @JoinColumn(name="emp_no",referencedColumnName = "emp_no")
    private EmployeeEntity empNo;
    private Integer salary;
    private LocalDate toDate;

    public SalaryEntity(EmployeeEntity empNo, Integer salary, LocalDate toDate) {
        this.empNo = empNo;
        this.salary = salary;
        this.toDate = toDate;
        this.salaryEntityId = new SalaryEntityId(empNo.getEmpNo(), toDate);
    }


    @Override
    public String toString() {
        return "SalaryEntity{" +
                "id=" + salaryEntityId +
                ", empNo=" + empNo.getEmpNo() +
                ", salary=" + salary +
                ", toDate=" + toDate +
                '}';
    }


}

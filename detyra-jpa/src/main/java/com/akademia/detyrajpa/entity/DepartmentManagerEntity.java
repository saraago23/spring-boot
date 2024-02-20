package com.akademia.detyrajpa.entity;

import com.akademia.detyrajpa.entity.compositeprimarykeys.DepartmentManagerEntityId;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="dept_manager")
public class DepartmentManagerEntity {
    @EmbeddedId
    private DepartmentManagerEntityId departmentManagerEntityId;
    @ManyToOne
    @MapsId("empNo")
    @JoinColumn(name="emp_no", referencedColumnName = "emp_no")
    private EmployeeEntity empNo;
    @ManyToOne
    @MapsId("deptNo")
    @JoinColumn(name="dept_no", referencedColumnName = "dept_no")
    private DepartmentEntity deptNo;
    private LocalDate fromDate;
    private LocalDate toDate;

    @Override
    public String toString() {
        return "DepartmentManagerEntity{" +
                "id=" + departmentManagerEntityId +
                ", empNo=" + empNo +
                ", deptNo=" + deptNo +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}

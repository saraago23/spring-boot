package com.akademia.detyrajpa.entity.resultclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDepartment {
    String deptNo;
    String deptName;
    Long employeeCount;

    public EmployeeDepartment(String deptNo, String deptName, Long employeeCount) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.employeeCount = employeeCount;
    }

    @Override
    public String toString() {
        return
                " employeeCount=" + employeeCount ;
    }
}

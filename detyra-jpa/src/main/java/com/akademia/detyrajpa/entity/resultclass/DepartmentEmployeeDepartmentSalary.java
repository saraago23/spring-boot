package com.akademia.detyrajpa.entity.resultclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentEmployeeDepartmentSalary {

    String deptNo;
    String deptName;
    Double avgSalary;

    public DepartmentEmployeeDepartmentSalary(String deptNo, String deptName, Double avgSalary) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.avgSalary = avgSalary;
    }

    @Override
    public String toString() {
        return "DepartmentEmployeeDepartmentSalary{" +
                "deptNo='" + deptNo + '\'' +
                ", deptName='" + deptName + '\'' +
                ", avgSalary=" + avgSalary +
                '}';
    }
}

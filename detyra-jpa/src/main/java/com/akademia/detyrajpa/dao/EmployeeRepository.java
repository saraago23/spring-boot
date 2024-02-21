package com.akademia.detyrajpa.dao;

import com.akademia.detyrajpa.dao.generic.BaseDao;
import com.akademia.detyrajpa.entity.EmployeeEntity;
import com.akademia.detyrajpa.entity.resultclass.EmployeeDepartment;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends BaseDao<EmployeeEntity,Integer> {
    List<EmployeeEntity> getEmployeeAfterHireDate(LocalDate hireDate);
    List<EmployeeEntity> getEmployeeWithSalaryGreaterThan(Integer salary);
    List<EmployeeEntity> getAllEmployeesWithTitle(String title);

    List<EmployeeDepartment> getEmployeesNumberPerDepartment(String deptName);

}

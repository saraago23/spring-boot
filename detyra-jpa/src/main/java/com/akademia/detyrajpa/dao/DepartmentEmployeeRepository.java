package com.akademia.detyrajpa.dao;

import com.akademia.detyrajpa.dao.generic.BaseDao;
import com.akademia.detyrajpa.entity.DepartmentEmployeeEntity;
import com.akademia.detyrajpa.entity.SalaryEntity;
import com.akademia.detyrajpa.entity.compositeprimarykeys.DepartmentEmployeeEntityId;
import com.akademia.detyrajpa.entity.resultclass.DepartmentEmployeeDepartmentSalary;

import java.util.List;


public interface DepartmentEmployeeRepository extends BaseDao<DepartmentEmployeeEntity, DepartmentEmployeeEntityId> {

    List<DepartmentEmployeeDepartmentSalary> getAvarageSalaryPerDepartment();
}

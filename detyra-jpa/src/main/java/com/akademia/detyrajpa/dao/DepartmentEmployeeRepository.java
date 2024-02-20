package com.akademia.detyrajpa.dao;

import com.akademia.detyrajpa.dao.generic.BaseDao;
import com.akademia.detyrajpa.entity.DepartmentEmployeeEntity;
import com.akademia.detyrajpa.entity.SalaryEntity;
import com.akademia.detyrajpa.entity.compositeprimarykeys.DepartmentEmployeeEntityId;

import java.util.List;


public interface DepartmentEmployeeRepository extends BaseDao<DepartmentEmployeeEntity, DepartmentEmployeeEntityId> {

    List<SalaryEntity> getAvarageSalaryPerDepartment();
}

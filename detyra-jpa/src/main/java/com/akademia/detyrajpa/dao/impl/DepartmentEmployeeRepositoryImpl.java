package com.akademia.detyrajpa.dao.impl;

import com.akademia.detyrajpa.dao.DepartmentEmployeeRepository;
import com.akademia.detyrajpa.dao.DepartmentManagerRepository;
import com.akademia.detyrajpa.dao.generic.BaseDaoImpl;
import com.akademia.detyrajpa.entity.DepartmentEmployeeEntity;
import com.akademia.detyrajpa.entity.DepartmentManagerEntity;
import com.akademia.detyrajpa.entity.SalaryEntity;
import com.akademia.detyrajpa.entity.compositeprimarykeys.DepartmentEmployeeEntityId;
import com.akademia.detyrajpa.entity.compositeprimarykeys.DepartmentManagerEntityId;
import com.akademia.detyrajpa.entity.resultclass.DepartmentEmployeeDepartmentSalary;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentEmployeeRepositoryImpl extends BaseDaoImpl<DepartmentEmployeeEntity, DepartmentEmployeeEntityId> implements DepartmentEmployeeRepository {
    private static Logger logger = LoggerFactory.getLogger(DepartmentEmployeeRepositoryImpl.class);
    @PersistenceContext
    private EntityManager em;

    public DepartmentEmployeeRepositoryImpl() {
        super(DepartmentEmployeeRepositoryImpl.class.getTypeName(), DepartmentEmployeeEntity.class);
    }

    @Override
    protected EntityManager getEm() {
        return em;
    }

    @Override
    public List<DepartmentEmployeeDepartmentSalary> getAvarageSalaryPerDepartment() {
        TypedQuery<DepartmentEmployeeDepartmentSalary> query=
                em.createQuery("SELECT NEW com.akademia.detyrajpa.entity.resultclass.DepartmentEmployeeDepartmentSalary" +
                        "(de.departmentEmployeeEntityId.deptNo, d.deptName, AVG(s.salary)) " +
                        "FROM DepartmentEmployeeEntity de JOIN DepartmentEntity d ON de.departmentEmployeeEntityId.deptNo=d.deptNo " +
                        "JOIN SalaryEntity s ON de.departmentEmployeeEntityId.empNo = s.salaryEntityId.empNo " +
                        "GROUP BY de.departmentEmployeeEntityId.deptNo,d.deptName",DepartmentEmployeeDepartmentSalary.class);
        query.setFirstResult(0);
        query.setMaxResults(20);
        return query.getResultList();
    }
}

package com.akademia.detyrajpa.dao.impl;

import com.akademia.detyrajpa.dao.DepartmentEmployeeRepository;
import com.akademia.detyrajpa.dao.DepartmentManagerRepository;
import com.akademia.detyrajpa.dao.generic.BaseDaoImpl;
import com.akademia.detyrajpa.entity.DepartmentEmployeeEntity;
import com.akademia.detyrajpa.entity.DepartmentManagerEntity;
import com.akademia.detyrajpa.entity.SalaryEntity;
import com.akademia.detyrajpa.entity.compositeprimarykeys.DepartmentEmployeeEntityId;
import com.akademia.detyrajpa.entity.compositeprimarykeys.DepartmentManagerEntityId;
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
    public List<SalaryEntity> getAvarageSalaryPerDepartment() {
        TypedQuery<SalaryEntity> query= em.createQuery("SELECT de.departmentEmployeeEntityId.deptNo, d.deptName, AVG(s.salary) AS avg_salary FROM DepartmentEmployeeEntity de JOIN DepartmentEntity d JOIN SalaryEntity s GROUP BY de.departmentEmployeeEntityId.deptNo,d.deptName",SalaryEntity.class);
        query.setFirstResult(0);
        query.setMaxResults(20);
        return query.getResultList();
    }
}

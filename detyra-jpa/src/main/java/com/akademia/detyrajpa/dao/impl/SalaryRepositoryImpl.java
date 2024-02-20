package com.akademia.detyrajpa.dao.impl;

import com.akademia.detyrajpa.dao.EmployeeRepository;
import com.akademia.detyrajpa.dao.SalaryRepository;
import com.akademia.detyrajpa.dao.generic.BaseDaoImpl;
import com.akademia.detyrajpa.entity.EmployeeEntity;
import com.akademia.detyrajpa.entity.SalaryEntity;
import com.akademia.detyrajpa.entity.compositeprimarykeys.SalaryEntityId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalaryRepositoryImpl extends BaseDaoImpl<SalaryEntity, SalaryEntityId> implements SalaryRepository {
    private static Logger logger = LoggerFactory.getLogger(SalaryRepositoryImpl.class);
    @PersistenceContext
    private EntityManager em;

    public SalaryRepositoryImpl() {
        super(SalaryRepositoryImpl.class.getTypeName(), SalaryEntity.class);
    }

    @Override
    protected EntityManager getEm() {
        return em;
    }

    @Override
    public List<SalaryEntity> getLatestSalaryForAllEmployees() {
        TypedQuery<SalaryEntity> query = em.createQuery(" SELECT s.empNo, s.salary, MAX(s.salaryEntityId.fromDate) FROM SalaryEntity s WHERE (s.empNo, s.salaryEntityId.fromDate) IN  (SELECT s2.empNo, MAX(s2.salaryEntityId.fromDate)  FROM SalaryEntity s2 GROUP BY s2.empNo) GROUP BY s.empNo, s.salary", SalaryEntity.class);
        query.setFirstResult(0);
        query.setMaxResults(20);
        return query.getResultList();

    }

}

package com.akademia.detyrajpa.dao.impl;

import com.akademia.detyrajpa.dao.EmployeeRepository;
import com.akademia.detyrajpa.dao.generic.BaseDaoImpl;
import com.akademia.detyrajpa.entity.EmployeeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl extends BaseDaoImpl<EmployeeEntity, Integer> implements EmployeeRepository {
    private static Logger logger = LoggerFactory.getLogger(EmployeeRepositoryImpl.class);
    @PersistenceContext
    private EntityManager em;

    public EmployeeRepositoryImpl() {
        super(EmployeeRepositoryImpl.class.getTypeName(), EmployeeEntity.class);
    }

    @Override
    protected EntityManager getEm() {
        return em;
    }

    @Override
    public List<EmployeeEntity> getEmployeeAfterHireDate(LocalDate hireDate) {
       TypedQuery<EmployeeEntity> query= em.createQuery("SELECT e FROM EmployeeEntity e WHERE e.hireDate > :hireDate ", EmployeeEntity.class);
       query.setParameter("hireDate",hireDate);
       return query.getResultList();
    }

    @Override
    public List<EmployeeEntity> getEmployeeWithSalaryGreaterThan(Integer salary) {
        TypedQuery<EmployeeEntity> query=em.createQuery("SELECT e FROM EmployeeEntity e INNER JOIN SalaryEntity s ON e.empNo= s.salaryEntityId.empNo WHERE s.salary> :salary", EmployeeEntity.class);
        query.setParameter("salary",salary);
        return query.getResultList();
    }

    @Override
    public List<EmployeeEntity> getAllEmployeesWithTitle(String title) {
        TypedQuery<EmployeeEntity> query= em.createQuery(" SELECT e FROM EmployeeEntity e INNER JOIN TitleEntity t ON e.empNo = t.titleEntityId.empNo WHERE t.titleEntityId.title = :title " , EmployeeEntity.class);
        query.setParameter("title",title);
        return query.getResultList();
    }


}

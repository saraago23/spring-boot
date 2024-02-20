package com.akademia.detyrajpa.dao.impl;

import com.akademia.detyrajpa.dao.DepartmentManagerRepository;
import com.akademia.detyrajpa.dao.EmployeeRepository;
import com.akademia.detyrajpa.dao.generic.BaseDaoImpl;
import com.akademia.detyrajpa.entity.DepartmentManagerEntity;
import com.akademia.detyrajpa.entity.EmployeeEntity;
import com.akademia.detyrajpa.entity.compositeprimarykeys.DepartmentManagerEntityId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentManagerRepositoryImpl extends BaseDaoImpl<DepartmentManagerEntity, DepartmentManagerEntityId> implements DepartmentManagerRepository {
    private static Logger logger = LoggerFactory.getLogger(DepartmentManagerRepositoryImpl.class);
    @PersistenceContext
    private EntityManager em;

    public DepartmentManagerRepositoryImpl() {
        super(DepartmentManagerRepositoryImpl.class.getTypeName(), DepartmentManagerEntity.class);
    }

    @Override
    protected EntityManager getEm() {
        return em;
    }
}

package com.akademia.detyrajpa.dao.impl;

import com.akademia.detyrajpa.dao.EmployeeRepository;
import com.akademia.detyrajpa.dao.TitleRepository;
import com.akademia.detyrajpa.dao.generic.BaseDaoImpl;
import com.akademia.detyrajpa.entity.EmployeeEntity;
import com.akademia.detyrajpa.entity.TitleEntity;
import com.akademia.detyrajpa.entity.compositeprimarykeys.TitleEntityId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TitleRepositoryImpl extends BaseDaoImpl<TitleEntity, TitleEntityId> implements TitleRepository {
    private static Logger logger = LoggerFactory.getLogger(TitleRepositoryImpl.class);
    @PersistenceContext
    private EntityManager em;

    public TitleRepositoryImpl() {
        super(TitleRepositoryImpl.class.getTypeName(), TitleEntity.class);
    }

    @Override
    protected EntityManager getEm() {
        return em;
    }
}

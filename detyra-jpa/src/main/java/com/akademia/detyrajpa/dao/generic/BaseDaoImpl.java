package com.akademia.detyrajpa.dao.generic;

import com.akademia.detyrajpa.dao.generic.BaseDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseDaoImpl<T extends Object, I extends Serializable> implements BaseDao<T, I> {

    private Logger logger;
    private Class<T> type;

    public BaseDaoImpl(String loggerType, Class<T> type) {
        this.logger = LoggerFactory.getLogger(loggerType);
        this.type = type;
    }

    protected abstract EntityManager getEm();

    @Override
    public T save(T t) throws Exception {
        logger.info("calling save method");
        return getEm().merge(t);
    }

    @Override
    public Optional<T> findById(I i) throws Exception {
        logger.info("calling findById method");
        var entity = getEm().find(type, i);
        return entity != null ? Optional.of(entity) : Optional.empty();
    }

    @Override
    public void deleteById(I i) throws Exception {
        logger.info("calling deleteById method");
        findById(i).ifPresentOrElse(e -> getEm().remove(e), () -> logger.warn("Could not delete {}, with id: {} ", type.getName(), i));

    }

    @Override
    public List<T> findAll(int pageNumber,int pageSize,String sortBy, boolean asc) throws Exception {
        CriteriaBuilder cb = getEm().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(type);
        Root root = cq.from(type);
        Order order;
        if(asc)  order = cb.asc(root.get(sortBy));
        else order = cb.desc(root.get(sortBy));
        cq.select(root).orderBy(order);
        TypedQuery query = getEm().createQuery(cq);
        int first = (pageNumber-1)* pageSize;
        query.setFirstResult(first);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }
}

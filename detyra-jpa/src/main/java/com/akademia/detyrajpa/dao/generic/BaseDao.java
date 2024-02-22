package com.akademia.detyrajpa.dao.generic;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseDao<T extends Object, I extends Serializable> {
    T save(T t) throws Exception;

    Optional<T> findById(I i) throws Exception;

    void deleteById(I i) throws Exception;

    List<T> findAll(Integer pageNumber,Integer pageSize,String sortBy, boolean asc) throws Exception;
}

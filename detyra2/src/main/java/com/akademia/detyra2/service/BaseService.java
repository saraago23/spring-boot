package com.akademia.detyra2.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<T extends Object, I extends Serializable> {

    T save(T t) throws Exception;

    Optional<T> findById(I i) throws Exception;

    void deleteById(I i) throws Exception;

    List<T> showAll()throws Exception;

}

package com.akademia.detyrajpa.dao;

import com.akademia.detyrajpa.dao.generic.BaseDao;
import com.akademia.detyrajpa.entity.SalaryEntity;
import com.akademia.detyrajpa.entity.compositeprimarykeys.SalaryEntityId;

import java.util.List;

public interface SalaryRepository extends BaseDao<SalaryEntity, SalaryEntityId> {

    List<SalaryEntity> getLatestSalaryForAllEmployees();

}

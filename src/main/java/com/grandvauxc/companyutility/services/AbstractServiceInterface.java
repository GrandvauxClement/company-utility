package com.grandvauxc.companyutility.services;

import java.util.List;

public interface AbstractServiceInterface<T, ID> {

    public T create(T entity);

    public T findById(ID idEntity);

    public List<T> findAll();

    public void updateById(ID id, T entity);

    public void deleteById(ID id, T entity);

    public void deleteAll();
}

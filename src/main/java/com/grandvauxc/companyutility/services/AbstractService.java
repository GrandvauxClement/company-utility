package com.grandvauxc.companyutility.services;

import com.grandvauxc.companyutility.exceptions.EntityNotFoundException;
import com.grandvauxc.companyutility.repository.CompanyUtilityRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public abstract class AbstractService<T, ID extends Serializable, R extends CompanyUtilityRepository<T, ID>> implements AbstractServiceInterface<T,ID>{

    protected final R repository;

    AbstractService() {
        this.repository = null;
    }
    public AbstractService(R repository) {
        this.repository = repository;
    }

    protected R getRepository(){
        return Objects.requireNonNull(repository);
    }
    @Override
    public T create(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public T findById(ID idEntity) {
        return getRepository().findById(idEntity).orElse(null);
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T updateById(ID id, T entity) {
        if (!getRepository().existsById(id)) throw new EntityNotFoundException((Class<?>) entity, id);
        return getRepository().save(entity);
    }

    @Override
    public void deleteById(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    public void deleteAll() {
        getRepository().deleteAll();
    }
}

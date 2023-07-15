package com.grandvauxc.companyutility.services;

import com.grandvauxc.companyutility.exceptions.EntityNotFoundException;
import com.grandvauxc.companyutility.repository.CompanyUtilityRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class AbstractService<T, ID extends Serializable, R extends CompanyUtilityRepository<T, ID>> implements AbstractServiceInterface<T,ID>{

    private final R repository;

    AbstractService() {
        this.repository = null;
    }
    public AbstractService(R repository) {
        this.repository = repository;
    }
    @Override
    public T create(T entity) {
        return repository.save(entity);
    }

    @Override
    public T findById(ID idEntity) {
        return repository.findById(idEntity).orElse(null);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void updateById(ID id, T entity) {
        if (!repository.existsById(id)) throw new EntityNotFoundException((Class<?>) entity, id);
        repository.save(entity);
    }

    @Override
    public void deleteById(ID id, T entity) {
        if (!repository.existsById(id)) throw new EntityNotFoundException((Class<?>) entity, id);
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {

    }
}

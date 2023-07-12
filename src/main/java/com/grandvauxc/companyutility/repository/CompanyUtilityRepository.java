package com.grandvauxc.companyutility.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface CompanyUtilityRepository<T, S extends Serializable> extends ListCrudRepository<T, S> {
}

package com.grandvauxc.companyutility.services;

import com.grandvauxc.companyutility.entity.Company;
import com.grandvauxc.companyutility.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CompanyService extends AbstractService<Company, UUID, CompanyRepository> {

    public CompanyService(CompanyRepository repository) {
        super(repository);
    }
}

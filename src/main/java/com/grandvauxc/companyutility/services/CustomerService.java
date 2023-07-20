package com.grandvauxc.companyutility.services;

import com.grandvauxc.companyutility.entity.Customer;
import com.grandvauxc.companyutility.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService extends AbstractService<Customer, UUID, CustomerRepository> {

    public CustomerService(CustomerRepository repository) {
        super(repository);
    }
}

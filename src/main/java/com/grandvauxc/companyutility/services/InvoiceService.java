package com.grandvauxc.companyutility.services;

import com.grandvauxc.companyutility.entity.Invoice;
import com.grandvauxc.companyutility.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InvoiceService extends AbstractService<Invoice, UUID, InvoiceRepository>{

    public InvoiceService(InvoiceRepository repository) {
        super(repository);
    }
}

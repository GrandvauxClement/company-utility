package com.grandvauxc.companyutility.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class InvoiceDto implements Serializable {
    private final UUID id;
    private final String place;
    private final Long number;
    private final LocalDateTime createdAt;
    private final LocalDateTime dateLimit;
    private final List<InvoiceLineDto> invoiceLineList;
    private final CustomerDto customer;
    private final CompanyDto company;
}

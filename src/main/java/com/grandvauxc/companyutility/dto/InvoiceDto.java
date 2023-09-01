package com.grandvauxc.companyutility.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class InvoiceDto extends AbstractDto {

    private String place;

    private Long number;

    private LocalDateTime createdAt;

    private LocalDateTime dateLimit;

    private List<InvoiceLineDto> invoiceLineList;

    private CustomerDto customer;

    private CompanyDto company;
}

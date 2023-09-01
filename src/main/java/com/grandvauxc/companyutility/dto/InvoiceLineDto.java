package com.grandvauxc.companyutility.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class InvoiceLineDto extends AbstractDto {

    private Long quantity;

    private Float priceHt;

    private String tva;

    private String description;

    private UUID invoiceId;
}

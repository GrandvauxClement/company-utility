package com.grandvauxc.companyutility.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class InvoiceLineDto implements Serializable {
    private final UUID id;
    private final Long quantity;
    private final Float priceHt;
    private final String tva;
    private final String description;
    private final UUID invoiceId;
}

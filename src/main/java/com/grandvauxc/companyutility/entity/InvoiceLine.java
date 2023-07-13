package com.grandvauxc.companyutility.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "invoice_line")
public class InvoiceLine extends AbstractEntity{

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "price_ht", nullable = false)
    private Float priceHt;

    @Column(name = "tva", nullable = false)
    private String tva;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    private Invoice invoice;
}

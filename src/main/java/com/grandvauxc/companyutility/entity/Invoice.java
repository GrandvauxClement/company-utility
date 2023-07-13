package com.grandvauxc.companyutility.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "invoice_line")
public class Invoice extends AbstractEntity{

    @Column(name = "place", nullable = false)
    private String place;

    @Column(name = "number", nullable = false)
    private Long number;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "dateLimit")
    private LocalDateTime dateLimit;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceLine> invoiceLineList;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Company company;
}

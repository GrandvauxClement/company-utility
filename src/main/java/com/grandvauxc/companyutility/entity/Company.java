package com.grandvauxc.companyutility.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company")
public class Company extends AbstractContact{

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "company")
    private List<Invoice> invoiceList;
}

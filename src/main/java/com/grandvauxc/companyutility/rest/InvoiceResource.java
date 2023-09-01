package com.grandvauxc.companyutility.rest;


import com.grandvauxc.companyutility.dto.InvoiceDto;
import com.grandvauxc.companyutility.entity.Invoice;
import com.grandvauxc.companyutility.mapper.MapperService;
import com.grandvauxc.companyutility.services.InvoiceService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
@SecurityRequirement(name = "logApi")
@RequestMapping("/api/invoice")
public class InvoiceResource {

    private final InvoiceService invoiceService;

    private final MapperService mapperService;

    @GetMapping
    public ResponseEntity<List<InvoiceDto>> getAllInvoices(){
        List<Invoice> InvoiceList = invoiceService.findAll();
        List<InvoiceDto> InvoiceDtoList = InvoiceList.stream().map(Invoice ->
                this.mapperService.map(Invoice, InvoiceDto.class)).collect(Collectors.toList());
        return new ResponseEntity<>(InvoiceDtoList, HttpStatus.OK);
    }

    @GetMapping("/{idInvoice}")
    public ResponseEntity<InvoiceDto> getInvoiceById(@PathVariable UUID idInvoice){
        Invoice Invoice = invoiceService.findById(idInvoice);
        InvoiceDto InvoiceDto = mapperService.map(Invoice, InvoiceDto.class);
        return new ResponseEntity<>(InvoiceDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InvoiceDto> createInvoice(@RequestBody InvoiceDto InvoiceDto){
        Invoice Invoice = mapperService.map(InvoiceDto, Invoice.class);
        InvoiceDto InvoiceCreated = mapperService.map(invoiceService.create(Invoice), InvoiceDto.class);
        return new ResponseEntity<>(InvoiceCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{idInvoice}")
    public ResponseEntity<InvoiceDto> updateInvoice(@PathVariable UUID idInvoice, @RequestBody InvoiceDto InvoiceDto){
        Invoice Invoice = mapperService.map(InvoiceDto, Invoice.class);
        InvoiceDto InvoiceDtoUpdated = mapperService.map(invoiceService.updateById(idInvoice,Invoice), InvoiceDto.class);
        return new ResponseEntity<>(InvoiceDtoUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{idInvoice}")
    public ResponseEntity<String> deleteInvoiceById(@PathVariable UUID idInvoice){
        invoiceService.deleteById(idInvoice);
        return new ResponseEntity<>("Invoice with id " + idInvoice + "deleted", HttpStatus.OK);
    }
}

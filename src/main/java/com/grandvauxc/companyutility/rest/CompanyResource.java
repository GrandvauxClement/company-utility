package com.grandvauxc.companyutility.rest;

import com.grandvauxc.companyutility.dto.CompanyDto;
import com.grandvauxc.companyutility.entity.Company;
import com.grandvauxc.companyutility.services.CompanyService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/company")
public class CompanyResource {

    @Autowired
    private CompanyService companyService;

    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getAllCompany(){
        List<Company> companyList = companyService.findAll();
        return new ResponseEntity<>(companyList.stream().map(company ->
                this.modelMapper.map(company, CompanyDto.class)).collect(Collectors.toList()),
                HttpStatus.OK);
    }
}

package com.grandvauxc.companyutility.rest;

import com.grandvauxc.companyutility.dto.CompanyDto;
import com.grandvauxc.companyutility.entity.Company;
import com.grandvauxc.companyutility.services.CompanyService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/company")
public class CompanyResource {


    final CompanyService companyService;

    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getAllCompany(){
        List<Company> companyList = companyService.findAll();
        List<CompanyDto> companyDtoList = companyList.stream().map(company ->
                this.modelMapper.map(company, CompanyDto.class)).collect(Collectors.toList());
        return new ResponseEntity<>(companyDtoList, HttpStatus.OK);
    }

    @GetMapping("/{idCompany}")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable UUID idCompany){
        Company company = companyService.findById(idCompany);
        CompanyDto companyDto = modelMapper.map(company, CompanyDto.class);
        return new ResponseEntity<>(companyDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyDto companyDto){
        Company company = modelMapper.map(companyDto, Company.class);
        CompanyDto companyCreated = modelMapper.map(companyService.create(company), CompanyDto.class);
        return new ResponseEntity<>(companyCreated, HttpStatus.CREATED);
    }
}

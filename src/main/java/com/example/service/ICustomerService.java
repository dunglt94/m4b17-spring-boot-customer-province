package com.example.service;

import com.example.model.Customer;
import com.example.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGenerateService<Customer> {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByProvince(Province province, Pageable pageable);

    Page<Customer> findAllByName(String firstName, String lastName, Pageable pageable);

    Page<Customer> findAllByFullName(String fullName, Pageable pageable);
}

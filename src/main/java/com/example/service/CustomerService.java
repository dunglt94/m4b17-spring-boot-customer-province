package com.example.service;

import com.example.model.Customer;
import com.example.model.Province;
import com.example.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByProvince(Province province, Pageable pageable) {
        return customerRepository.findAllByProvince(province, pageable);
    }

    @Override
    public Page<Customer> findAllByName(String firstName, String lastName, Pageable pageable) {
        return customerRepository.findAllByFirstNameOrLastNameContaining(firstName, lastName, pageable);
    }

    @Override
    public Page<Customer> findAllByFullName(String fullName, Pageable pageable) {
        return customerRepository.findByFullName(fullName, pageable);
    }
}

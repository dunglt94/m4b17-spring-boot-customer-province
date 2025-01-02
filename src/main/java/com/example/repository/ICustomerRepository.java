package com.example.repository;

import com.example.model.Customer;
import com.example.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByProvince(Province province, Pageable pageable);

    Page<Customer> findAllByFirstNameOrLastNameContaining(String firstName, String lastName, Pageable pageable);

    @Query("SELECT c FROM Customer c WHERE CONCAT(c.firstName, ' ', c.lastName) LIKE %:fullName%")
    Page<Customer> findByFullName(@Param("fullName") String fullName, Pageable pageable);
}

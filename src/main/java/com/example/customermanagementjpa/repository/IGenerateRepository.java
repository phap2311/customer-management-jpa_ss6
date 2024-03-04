package com.example.customermanagementjpa.repository;

import com.example.customermanagementjpa.model.Customer;

import java.util.List;

public interface IGenerateRepository {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(Long id);

    void remove(Long id);
}

package com.example.customermanagementjpa.service;

import com.example.customermanagementjpa.model.Customer;

import java.util.List;

public interface IGenerateService {
    List<Customer> findAll();

    void save(Customer customer);


    Customer findById(Long id);


    void remove(Long id);
}

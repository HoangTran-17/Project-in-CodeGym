package com.codegym.motorcycle.controller;

import com.codegym.motorcycle.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{
    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Page<Customer> findAll() {
        return null;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.empty();
    }
}

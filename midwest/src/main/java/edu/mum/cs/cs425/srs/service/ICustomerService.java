package edu.mum.cs.cs425.srs.service;

import edu.mum.cs.cs425.srs.model.Customer;

import java.util.List;

public interface ICustomerService {
    public abstract List<Customer> findAll();
    public abstract Customer save(Customer customer);
    public List<Customer> findAllSort();
}

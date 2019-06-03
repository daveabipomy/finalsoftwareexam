package edu.mum.cs.cs425.srs.service.impl;

import edu.mum.cs.cs425.srs.model.Customer;
import edu.mum.cs.cs425.srs.repository.ICustomerRepository;
import edu.mum.cs.cs425.srs.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    public ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {

        List<Customer> accounts = customerRepository.findAll();
        return accounts.stream().sorted(Comparator.comparing(Customer::getLastName)).collect(Collectors.toList());
//        return customerRepository.findAll().stream().sorted((x,y)->x.getLastName().compareTo(y.getLastName())).collect(Collectors.toList());
    }

    public List<Customer> findAllSort() {

        List<Customer> accounts = customerRepository.findAll();
        return accounts.stream().sorted(Comparator.comparing(Customer::getLastName)).collect(Collectors.toList());
//        return customerRepository.findAll().stream().sorted((x,y)->x.getLastName().compareTo(y.getLastName())).collect(Collectors.toList());
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}

package edu.mum.cs.cs425.srs.repository;

import edu.mum.cs.cs425.srs.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
}

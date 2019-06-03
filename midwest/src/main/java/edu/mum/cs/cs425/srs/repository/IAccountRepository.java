package edu.mum.cs.cs425.srs.repository;

import edu.mum.cs.cs425.srs.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountRepository extends JpaRepository<Account,Long> {
    List<Account> findAllByOrderByAccountNumber();


}

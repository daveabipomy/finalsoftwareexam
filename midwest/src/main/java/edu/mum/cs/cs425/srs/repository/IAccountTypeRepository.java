package edu.mum.cs.cs425.srs.repository;

import edu.mum.cs.cs425.srs.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountTypeRepository extends JpaRepository<AccountType,Long> {
}

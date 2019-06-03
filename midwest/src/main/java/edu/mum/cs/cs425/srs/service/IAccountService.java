package edu.mum.cs.cs425.srs.service;

import edu.mum.cs.cs425.srs.model.Account;
import edu.mum.cs.cs425.srs.model.Customer;

import java.util.List;

public interface IAccountService {
    public abstract List<Account> findAll();
    public abstract Account save(Account account);
    public String liquidity();
}

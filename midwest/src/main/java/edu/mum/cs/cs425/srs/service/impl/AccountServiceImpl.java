package edu.mum.cs.cs425.srs.service.impl;

import edu.mum.cs.cs425.srs.model.Account;
import edu.mum.cs.cs425.srs.repository.IAccountRepository;
import edu.mum.cs.cs425.srs.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountRepository accountRepository;
    @Override
    public List<Account> findAll() {

        return accountRepository.findAll().stream().sorted((x,y)->x.getAccountNumber().compareTo(y.getAccountNumber())).collect(Collectors.toList());
    }

    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "lastName");
    }
    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public String liquidity()
    {
        DecimalFormat df2 = new DecimalFormat("#.##");
        List<Account> accounts=accountRepository.findAll();
        double loanSum=0.0;
        double moneySum=0.0;
        for(Account account:accounts)
        {
            if(account.getAccountType().accountTypeName.equals("Savings") || account.getAccountType().accountTypeName.equals("Checking"))
            {
                moneySum+=account.getBalance();
            }
            else if(account.getAccountType().accountTypeName.equals("Loan"))
            {
                loanSum+=account.getBalance();
            }
        }
//        System.out.println("moneyyyyyyyyyyyy" + (moneySum-loanSum));
        double result=moneySum-loanSum;
        return df2.format(result);
    }
}

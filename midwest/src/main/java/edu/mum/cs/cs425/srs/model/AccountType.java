package edu.mum.cs.cs425.srs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long accountTypeId;
    @NotNull(message = "Account name Required")
    public  String accountTypeName;
}

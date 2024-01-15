package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.resource.RequestAmount;
import com.example.resource.ResponseAmount;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    //新規口座開設
    public Account insert(RequestAmount requestAmount) {
    	Account account = new Account();
    	account.setAmount(0);
    	return this.accountRepository.save(account);
    }
    
    //特定口座の残高照会
    public ResponseAmount getResponseAmount(Integer accountId){
    	Account account = this.accountRepository.findById(accountId).get();
    	ResponseAmount responseAmount = new ResponseAmount();
    	responseAmount.setAmount(account.getAmount());
    	return responseAmount;
    }
    
}
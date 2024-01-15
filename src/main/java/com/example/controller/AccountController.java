package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.resource.RequestAmount;
import com.example.resource.ResponseAmount;
import com.example.service.AccountService;

@RestController
@RequestMapping(value = "bankTrading", produces = "application/json;charset = UTF-8")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    
    //新規口座開設
    @PostMapping("/open")
    public Account open(@RequestBody RequestAmount requestAmount) {
    	return this.accountService.insert(requestAmount);
    }
    
    //特定口座の残高照会
    @GetMapping("/{account_id}")
    public ResponseAmount getAmount(@PathVariable("account_id") Integer accountId) {
    	return accountService.getResponseAmount(accountId);
    }
    
    //預入機能
    @PostMapping("/deposit/{account_id}")
    public ResponseAmount deposit(@PathVariable("account_id")Integer accountId, 
    		@RequestBody RequestAmount requestAmount) {
    	return accountService.depositAccount(accountId, requestAmount);
    }
    
    //引き出し機能
    @PostMapping("/withdraw/{account_id}")
    public ResponseAmount withdraw(@PathVariable("account_id")Integer accountId,
    		@RequestBody RequestAmount requestAmount) {
    	return accountService.withdrawAccount(accountId, requestAmount);
    }
}
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.resource.RequestAmount;
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
}
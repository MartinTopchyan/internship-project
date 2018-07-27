package edu.inconcept.netflix.controller;

import edu.inconcept.netflix.entity.Account;
import edu.inconcept.netflix.service.impl.AccountServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    AccountServiceImpl accountServiceimpl;


    @RequestMapping(method = {RequestMethod.POST}, value = "/accounts")
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        return new ResponseEntity(this.accountServiceimpl.add(account), HttpStatus.CREATED);
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "/accounts/closestRating/{constant}")
    public ResponseEntity<List<Account>> getAccountsByClosestRating(@PathVariable String constant) {
        return new ResponseEntity(this.accountServiceimpl.findAccountsByClosestRating(constant), HttpStatus.OK);
    }
}
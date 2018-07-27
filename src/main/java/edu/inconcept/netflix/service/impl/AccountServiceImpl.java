package edu.inconcept.netflix.service.impl;

import edu.inconcept.netflix.entity.Account;
import edu.inconcept.netflix.repository.AccountRepository;
import edu.inconcept.netflix.service.AccountService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    public AccountServiceImpl() {
    }

    public Account findAccountByImdbId(Long id) {
        return this.accountRepository.findAccountByAccountImdbId(id);
    }

    public Account add(Account account) {
        return (Account)this.accountRepository.save(account);
    }

    public List<Account> bulkInsert(Collection<Account> values) {
        return this.accountRepository.saveAll(values);
    }

    public List<Account> findAccountsByClosestRating(String constant) {
        return this.accountRepository.findAccountsByClosestRating(constant);
    }
}
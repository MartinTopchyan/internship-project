package edu.inconcept.netflix.service;

import edu.inconcept.netflix.entity.Account;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    Account findAccountByImdbId(Long var1);

    Account add(Account var1);

    List<Account> bulkInsert(Collection<Account> var1);

    List<Account> findAccountsByClosestRating(String var1);
}
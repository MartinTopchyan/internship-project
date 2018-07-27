package edu.inconcept.netflix.repository;

import edu.inconcept.netflix.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
     Account findAccountByAccountImdbId(Long var1);

     @Query(value = "select * from account a join rating r on r.user_id = a.id join movie m on m.id = r.movie_id where" +
                     " abs(m.imdbrating - r.account_rated) < 1 and m.const = ?", nativeQuery = true)
     List<Account> findAccountsByClosestRating(@Param("const") String constant);
}

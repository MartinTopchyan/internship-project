package edu.inconcept.netflix.entity;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "account_imdb_id")
    private Long accountImdbId;

    public Account(Long imdbAccountID) {
        this.accountImdbId = imdbAccountID;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountImdbId() {
        return accountImdbId;
    }

    public void setAccountImdbId(Long accountImdbId) {
        this.accountImdbId = accountImdbId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                '}';
    }
}

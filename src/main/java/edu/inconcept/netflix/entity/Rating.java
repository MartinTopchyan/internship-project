package edu.inconcept.netflix.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "account_rated")
    private Integer accountRated;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "movie_id",referencedColumnName = "id")
    private Movie movie;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getaccountRated() {
        return accountRated;
    }

    public void setAccountRated(Integer accountRated) {
        this.accountRated = accountRated;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

}


package edu.inconcept.netflix.service.model;

import edu.inconcept.netflix.entity.*;
import edu.inconcept.netflix.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ImdbcsvRecord {

    private Long id;
    private String constant;
    private Date creatdeDate;
    private String title;
    private String titleTypeName;
    private List<String> directorsNames;
    private Integer accountRated;
    private Double imdbRated;
    private Integer runtime;
    private List<String> genres;
    private Long numVotes;
    private Date releseDate;
    private String url;
    private Long imdbAccountID;

    @Autowired
    AccountService accountService;
    public ImdbcsvRecord() {
    }

    public ImdbcsvRecord( String constant, Date creatdeDate, String title,
                         String titleTypeName, List<String> directorName,
                         Integer accountRated, Double imdbRated, Integer runtime, List<String> genre,
                         Long numVotes, Date releseDate, String url,Long imdbAccountId) {
        this.constant = constant;
        this.creatdeDate = creatdeDate;
        this.title = title;
        this.titleTypeName = titleTypeName;
        this.directorsNames = directorName;
        this.accountRated = accountRated;
        this.imdbRated = imdbRated;
        this.runtime = runtime;
        this.genres = genre;
        this.numVotes = numVotes;
        this.releseDate = releseDate;
        this.url = url;
        this.imdbAccountID = imdbAccountId;
    }

    public Long getId() {
        return id;
    }

    public String getConstant() {
        return constant;
    }

    public Date getCreatdeDate() {
        return creatdeDate;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleTypeName() {
        return titleTypeName;
    }

    public List<String> getDirectorsNames() {
        return directorsNames;
    }

    public Integer getAccountRated() {
        return accountRated;
    }

    public Double getImdbRated() {
        return imdbRated;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public Long getNumVotes() {
        return numVotes;
    }

    public Date getReleseDate() {
        return releseDate;
    }

    public String getUrl() {
        return url;
    }

    public String getTitleType() {
        return titleTypeName;
    }

    public List<String> getDirectors() {
        return directorsNames;
    }

    public List<String> getGenres() {
        return genres;
    }

    public long getAccountImdbId(){
        return imdbAccountID;
    }
}

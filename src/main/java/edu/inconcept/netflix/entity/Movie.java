package edu.inconcept.netflix.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "const")
    private String constant;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "iMDBRating")
    private Double iMDBRating;

    @Column(name = "runtime")
    private Integer runtime;

    @Column(name = "number_votes")
    private Long numberVotes;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "url",nullable = false)
    private String url;


    @ManyToMany
    @JoinTable(
            name = "movie_director",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "director_id",referencedColumnName = "id"))
    @JsonIgnore
    private List<Director> directors;

    @ManyToOne
    @JoinColumn(name = "title_type",referencedColumnName = "id")
    private TitleType titleType;

    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    @JsonIgnore
    private List<Genre> genres;

    public Movie(String constant) {
    }

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getIMDBRating() {
        return iMDBRating;
    }

    public void setIMDBRating(Double iMDbrating) {
        this.iMDBRating = iMDbrating;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public Long getNumberVotes() {
        return numberVotes;
    }

    public void setNumberVotes(Long numberVotes) {
        this.numberVotes = numberVotes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public TitleType getTitleType() {
        return titleType;
    }

    public void setTitleType(TitleType titleType) {
        this.titleType = titleType;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}

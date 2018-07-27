package edu.inconcept.netflix.service.dto;

import java.util.Date;
import java.util.List;

public class MovieDto {
    private Long id;
    private String constant;
    private String title;
    private Date created;
    private Double rating;
    private Integer runtime;
    private Long numberVotes;
    private java.sql.Date releaseDate;
    private String url;
    private DirectorDto directorDto;
    private TitleTypeDto titleTypeDto;
    private List<GenreDto> genreDtos;

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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
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

    public DirectorDto getDirectorDto() {
        return directorDto;
    }

    public void setDirectorDto(DirectorDto directorDto) {
        this.directorDto = directorDto;
    }

    public TitleTypeDto getTitleTypeDto() {
        return titleTypeDto;
    }

    public void setTitleTypeDto(TitleTypeDto titleTypeDto) {
        this.titleTypeDto = titleTypeDto;
    }

    public List<GenreDto> getGenreDtos() {
        return genreDtos;
    }

    public void setGenreDtos(List<GenreDto> genreDtos) {
        this.genreDtos = genreDtos;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    public java.sql.Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(java.sql.Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "id=" + id +
                ", constant='" + constant + '\'' +
                ", title='" + title + '\'' +
                ", created=" + created +
                ", rating=" + rating +
                ", runtime=" + runtime +
                ", numberVotes=" + numberVotes +
                ", releaseDate=" + releaseDate +
                ", url='" + url + '\'' +
                ", directorDto=" + directorDto +
                ", titleTypeDto=" + titleTypeDto +
                ", genreDtos=" + genreDtos +
                '}';
    }
}

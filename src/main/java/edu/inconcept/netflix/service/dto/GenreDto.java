package edu.inconcept.netflix.service.dto;

import java.util.List;

public class GenreDto {
    private Long id;
    private String name;
    private List<MovieDto> movieDtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MovieDto> getMovieDtos() {
        return movieDtos;
    }

    public void setMovieDtos(List<MovieDto> movieDtos) {
        this.movieDtos = movieDtos;
    }

    @Override
    public String toString() {
        return "GenreDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movieDtos=" + movieDtos +
                '}';
    }
}

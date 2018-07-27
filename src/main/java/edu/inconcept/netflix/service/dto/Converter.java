package edu.inconcept.netflix.service.dto;

import edu.inconcept.netflix.entity.Director;
import edu.inconcept.netflix.entity.Genre;
import edu.inconcept.netflix.entity.Movie;
import edu.inconcept.netflix.entity.TitleType;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static MovieDto mapMovieEntityToDto(Movie movie){
        MovieDto movieDto = new MovieDto();
        movieDto.setConstant(movie.getConstant());
        movieDto.setTitle(movie.getTitle());
     //   movieDto.setCreated(movie.getCreatedDate());
     //   movieDto.setRating(movie.getRating());
     //   movieDto.setRuntime(movie.getRuntime());
        movieDto.setNumberVotes(movie.getNumberVotes());
    //    movieDto.setReleaseDate(movie.getReleaseDate());
        movieDto.setUrl(movie.getUrl());
//        if(movie.getDirector() != null){
//            movieDto.setDirectorDto(mapDirectorEntityToDto(movie.getDirector()));
//        }else {
//            movieDto.setDirectorDto(null);
//        }
        if(movie.getTitleType() != null){
            movieDto.setTitleTypeDto(mapTitleTypeEntityToDto(movie.getTitleType()));
        }else{
            movieDto.setTitleTypeDto(null);
        }
        if(movie.getGenres() != null){
            movieDto.setGenreDtos(mapGenreEntityToDtos(movie.getGenres()));
        }else {
            movieDto.setGenreDtos(null);
        }

        movieDto.setId(movie.getId());
        return movieDto;

    }
    public static List<MovieDto> mapMovieEntityToDtos(List<Movie> movies){
        if(movies == null){
            return null;
        }
        List<MovieDto> movieDtos = new ArrayList<>();
        for(Movie movie: movies){
            movieDtos.add(mapMovieEntityToDto(movie));
        }
        return movieDtos;
    }

    public static Movie mapMovieDtoToEntity(MovieDto movieDto){
        Movie movie = new Movie();
        movie.setConstant(movieDto.getConstant());
        movie.setTitle(movieDto.getTitle());
     //   movie.setCreatedDate(movieDto.getCreated());
     //   movie.setRating(movieDto.getRating());
     //   movie.setRuntime(movieDto.getRuntime());
        movie.setNumberVotes(movieDto.getNumberVotes());
        movie.setReleaseDate(movieDto.getReleaseDate());
        movie.setUrl(movieDto.getUrl());
//        if(movieDto.getDirectorDto() != null){
//            movie.setDirector(mapDirectorDtoToEntity(movieDto.getDirectorDto()));
//        }else {
//            movie.setDirector(null);
//        }
        if(movieDto.getTitleTypeDto() != null){
            movie.setTitleType(mapTitleTypeDtoToEntity(movieDto.getTitleTypeDto()));
        }else{
            movie.setTitleType(null);
        }
        if(movieDto.getGenreDtos() != null){
            movie.setGenres(mapGenreDtosToEntities(movieDto.getGenreDtos()));
        }else {
            movie.setGenres(null);
        }
        movie.setId(movieDto.getId());
        return movie;
    }

    public static List<Movie> mapMovieDtosToEntities(List<MovieDto> movieDtoList){
        if(movieDtoList == null){
            return null;
        }
        List<Movie> movies = new ArrayList<>();
        for(MovieDto movieDto: movieDtoList){
            movies.add(mapMovieDtoToEntity(movieDto));
        }
        return movies;
    }


    public static DirectorDto mapDirectorEntityToDto(Director director){
        DirectorDto directorDto = new DirectorDto();
        directorDto.setName(director.getName());
        directorDto.setId(director.getId());
        return directorDto;

    }
    public static List<DirectorDto> mapDirectorsEntityToDtos(List<Director> directors){
        if(directors == null){
            return null;
        }
        List<DirectorDto> directorDtos = new ArrayList<>();
        for(Director director: directors){
            directorDtos.add(mapDirectorEntityToDto(director));
        }
        return directorDtos;
    }


    public static TitleTypeDto mapTitleTypeEntityToDto(TitleType titleType){
        TitleTypeDto titleTypeDto = new TitleTypeDto();
        titleTypeDto.setName(titleType.getName());
        titleTypeDto.setId(titleType.getId());
        return titleTypeDto;

    }
    public static List<TitleTypeDto> mapTitleTypesEntityToDtos(List<TitleType> titleTypes){
        if(titleTypes == null){
            return null;
        }
        List<TitleTypeDto> titleTypeDtos = new ArrayList<>();
        for(TitleType titleType: titleTypes){
            titleTypeDtos.add(mapTitleTypeEntityToDto(titleType));
        }
        return titleTypeDtos;
    }

    public static GenreDto mapGenreEntityToDto(Genre genre){
        GenreDto genreDto = new GenreDto();
        genreDto.setName(genre.getName());
        if(genreDto.getMovieDtos() != null){
            genreDto.setMovieDtos(mapMovieEntityToDtos(genre.getMovieList()));
        }
        else {
            genreDto.setMovieDtos(null);
        }
        genreDto.setId(genre.getId());
        return genreDto;

    }
    public static List<GenreDto> mapGenreEntityToDtos(List<Genre> genres){
        if(genres == null){
            return null;
        }
        List<GenreDto> genreDtos = new ArrayList<>();
        for(Genre genre: genres){
            genreDtos.add(mapGenreEntityToDto(genre));
        }
        return genreDtos;
    }

    public static Director mapDirectorDtoToEntity(DirectorDto directorDto){
        Director director = new Director();
        director.setName(directorDto.getName());
        director.setId(directorDto.getId());
        return director;
    }


    public static TitleType mapTitleTypeDtoToEntity(TitleTypeDto titleTypeDto){
        TitleType titleType = new TitleType();
        titleType.setName(titleTypeDto.getName());
        titleType.setId(titleTypeDto.getId());
        return titleType;
    }

    public static Genre mapGenreDtoToEntity(GenreDto genreDto) {
        Genre genre = new Genre();
        genre.setName(genreDto.getName());
        if (genreDto.getMovieDtos() != null) {
            genre.setMovieList(mapMovieDtosToEntities(genreDto.getMovieDtos()));
        } else {
            genre.setMovieList(null);
        }
        genre.setId(genreDto.getId());
        return genre;
    }

    public static List<Genre> mapGenreDtosToEntities(List<GenreDto> genreDtos){
        if(genreDtos == null){
            return null;
        }
        List<Genre> genres = new ArrayList<>();
        for(GenreDto genreDto: genreDtos){
            genres.add(mapGenreDtoToEntity(genreDto));
        }
        return genres;
    }


}

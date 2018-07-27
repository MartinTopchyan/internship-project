package edu.inconcept.netflix.service.impl;


import edu.inconcept.netflix.entity.Movie;
import edu.inconcept.netflix.repository.MovieRepository;
import java.util.Collection;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovieService {
    private MovieRepository movieRepository;
    private static final Integer PAGESIZE = 3;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie add(Movie movie) {
        return (Movie)this.movieRepository.save(movie);
    }

    public List<Movie> getAll() throws ServiceException {
        List<Movie> movies = this.movieRepository.findAll();
        return movies;
    }

    public Movie getById(Long id) throws ServiceException {
        Movie movie = this.movieRepository.findMovieById(id);
        return movie;
    }

    public void delete(Long id) throws ServiceException {
        this.movieRepository.deleteById(id);
    }

    public List<Movie> getMoviesByGenre(String genreName) throws ServiceException {
        List<Movie> movies = this.movieRepository.findAllByGenre(genreName);
        return movies;
    }

    public List<Movie> getMoviesGreaterAvgRating(Double rated) {
        List<Movie> movies = this.movieRepository.findMoviesGreaterAvgRating(rated);
        return movies;
    }

    public List<Movie> getMoviesByDirector(String directorName) {
        List<Movie> movies = this.movieRepository.findMoviesByDirector(directorName);
        return movies;
    }

    public List<Movie> getMoviesByTitle(String title) {
        List<Movie> movies = this.movieRepository.findMoviesByName(title);
        return movies;
    }

    public List<Movie> bulkInsert(Collection<Movie> values) {
        return this.movieRepository.saveAll(values);
    }

    public List<Movie> getMovieesByPage(Integer offset) {
        return this.movieRepository.getAllByPaging(offset);
    }
}
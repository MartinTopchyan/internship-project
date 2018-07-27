package edu.inconcept.netflix.controller;

import edu.inconcept.netflix.entity.Movie;
import edu.inconcept.netflix.service.ImportMovieService;
import edu.inconcept.netflix.service.impl.MovieService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private ImportMovieService importMovieService;


    @RequestMapping(method = {RequestMethod.GET}, value = "/movies/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return new ResponseEntity(movieService.getById(id), HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity(movieService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "/movies/genre/name/{genreName}")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genreName) {
        return new ResponseEntity(movieService.getMoviesByGenre(genreName), HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "/movies/avgRating/greater/{rated}")
    public ResponseEntity<List<Movie>> getMoviesGreaterAvgRating(@PathVariable Double rated) {
        return new ResponseEntity(movieService.getMoviesGreaterAvgRating(rated), HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "/movies/director/name/{directorName}")
    public ResponseEntity<List<Movie>> getMoviesByDirector(@PathVariable String directorName) {
        return new ResponseEntity(movieService.getMoviesByDirector(directorName), HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "/movies/title/{title}")
    public ResponseEntity<List<Movie>> getMoviesByTitle(@PathVariable String title) {
        return new ResponseEntity(movieService.getMoviesByTitle(title), HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.POST}, value = "/movies/import")
    public ResponseEntity importMovies() {
        try {
            this.importMovieService.importMovie();
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (IOException var2) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(
            method = {RequestMethod.GET},
            value = {"paging/movies/{offset}"}
    )
    public ResponseEntity<List<Movie>> getByPage(@PathVariable Integer offset) {
        return new ResponseEntity(this.movieService.getMovieesByPage(offset), HttpStatus.OK);
    }
}

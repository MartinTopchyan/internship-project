package edu.inconcept.netflix.service.impl;

import edu.inconcept.netflix.entity.*;
import edu.inconcept.netflix.service.*;
import edu.inconcept.netflix.service.ImportMovieService;
import edu.inconcept.netflix.service.model.ImdbcsvRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
@Service
@Transactional
public class ImportMovieServiceImpl implements ImportMovieService {

    @Autowired
    ImdbCSVParserService imdbCSVParserService;

    @Autowired
    MovieService movieService;

    @Autowired
    RatingService ratingService;

    @Value("${application.moviecsv.path}")
    String csvPath;

    @Autowired
    TitleTypeService titleTypeService;

    @Autowired
    DirectorService directorService;

    @Autowired
    GenreService genreService;

    @Autowired
    AccountService accountService;


    private Map<String,TitleType> titleTypeMap;

    private Map<String,Director> directorMap;

    private Map<String,Genre>  genreMap;

    private Map<Long,Account> accountMap;

    private Map<String,Movie> movieMap = new HashMap<>();

    private List<Rating> ratingList = new ArrayList<>();

    @Override
    public void importMovie() throws IOException {
        List<ImdbcsvRecord> imdbcsvRecords = imdbCSVParserService.parseImdbCsv(csvPath);
        addToMaps(imdbcsvRecords);

        titleTypeService.bulkInsert(titleTypeMap.values());
        accountService.bulkInsert(accountMap.values());
        genreService.bulkInsert(genreMap.values());
        directorService.bulkInsert(directorMap.values());
        movieService.bulkInsert(movieMap.values());

        for(ImdbcsvRecord imdbcsvRecord : imdbcsvRecords){
            Rating rating = new Rating();
            rating.setCreatedDate(imdbcsvRecord.getCreatdeDate());
            rating.setMovie(movieMap.get(imdbcsvRecord.getConstant()));
            rating.setAccountRated(imdbcsvRecord.getAccountRated());
            rating.setAccount(accountMap.get(imdbcsvRecord.getAccountImdbId()));
            ratingList.add(rating);
        }
        ratingService.bulkInsert(ratingList);
    }



    private void addToMaps(List<ImdbcsvRecord> imdbcsvRecords){

        titleTypeMap = imdbcsvRecords.stream()
                .map(ImdbcsvRecord::getTitleType)
                .distinct()
                .collect(Collectors.toMap(Function.identity(), this::createTitleType));

        directorMap = imdbcsvRecords.stream()
                .flatMap(record -> record.getDirectors().stream())
                .distinct()
                .collect(Collectors.toMap(Function.identity(), this::createDirector));

        genreMap = imdbcsvRecords.stream()
                .flatMap(record -> record.getGenres().stream())
                .distinct()
                .collect(Collectors.toMap(Function.identity(), this::createGenre));

        accountMap = imdbcsvRecords.stream()
                .map(ImdbcsvRecord ::getAccountImdbId)
                .distinct()
                .collect(Collectors.toMap(Function.identity(), this::createAccount));

        for(ImdbcsvRecord imdbcsvRecord:imdbcsvRecords){
            Movie movie = movieMap.get(imdbcsvRecord.getConstant());
            if(movie == null){
                movie = createMovie(imdbcsvRecord);
                movieMap.put(movie.getConstant(),movie);
            }
        }
    }

    private Movie createMovie(ImdbcsvRecord imdbcsvRecord) {
        Movie movie = new Movie();
        movie.setConstant(imdbcsvRecord.getConstant());
        movie.setTitle(imdbcsvRecord.getTitle());
        movie.setNumberVotes(imdbcsvRecord.getNumVotes());
        movie.setIMDBRating(imdbcsvRecord.getImdbRated());
        movie.setRuntime(imdbcsvRecord.getRuntime());
        movie.setReleaseDate(imdbcsvRecord.getReleseDate());
        movie.setUrl(imdbcsvRecord.getUrl());
        movie.setTitleType(titleTypeMap.get(imdbcsvRecord.getTitleType()));
        movie.setDirectors(imdbcsvRecord.getDirectors().stream().map(directorMap::get).collect(Collectors.toList()));
        movie.setGenres(imdbcsvRecord.getGenres().stream().map(genreMap::get).collect(Collectors.toList()));
        return movie;
    }

    private Account  createAccount(Long accountImdbId){
        Account account = new Account(accountImdbId);
        return accountService.add(new Account(accountImdbId));
    }

    private TitleType createTitleType(String name){
        TitleType titleType = new TitleType(name);
    //    titleType = titleTypeService.save(titleType);
        return titleType;
    }

    private Director createDirector(String name){
        Director director = new Director(name);
     //   director = directorService.save(director);
        return director;
    }

    private Genre createGenre(String name){
        Genre genre = new Genre(name);
     //   genre = genreService.save(genre);
        return genre;
    }

}

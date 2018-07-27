package edu.inconcept.netflix.service;

import edu.inconcept.netflix.entity.Genre;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface GenreService {
    Genre findGenreByName(String name);

    Genre save(Genre genre);

    List<Genre> bulkInsert(Collection<Genre> values);
}

package edu.inconcept.netflix.service.impl;

import edu.inconcept.netflix.entity.Genre;
import edu.inconcept.netflix.repository.GenreRepository;
import edu.inconcept.netflix.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

    @Autowired
    GenreRepository genreRepository;

    @Override
    public Genre findGenreByName(String name) {
        return genreRepository.findByName(name);
    }

    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public List<Genre> bulkInsert(Collection<Genre> values) {
        return genreRepository.saveAll(values);
    }
}

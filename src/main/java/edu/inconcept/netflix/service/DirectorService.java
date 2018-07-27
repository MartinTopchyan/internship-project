package edu.inconcept.netflix.service;

import edu.inconcept.netflix.entity.Director;
import edu.inconcept.netflix.entity.Genre;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface DirectorService {
    Director findDirectorByName(String name);

    Director save(Director director);

    List<Director> bulkInsert(Collection<Director> values);
}

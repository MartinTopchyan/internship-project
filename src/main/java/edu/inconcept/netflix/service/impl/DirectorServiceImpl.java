package edu.inconcept.netflix.service.impl;

import edu.inconcept.netflix.entity.Director;
import edu.inconcept.netflix.repository.DirectorRepository;
import edu.inconcept.netflix.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    DirectorRepository directorRepository;

    @Override
    public Director findDirectorByName(String name) {
        return directorRepository.findByName(name);
    }

    @Override
    public Director save(Director director) {
        return directorRepository.save(director);
    }

    @Override
    public List<Director> bulkInsert(Collection<Director> values) {
        return directorRepository.saveAll(values);
    }
}

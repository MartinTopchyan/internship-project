package edu.inconcept.netflix.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public interface ImportMovieService {
    public void importMovie()throws IOException;
}

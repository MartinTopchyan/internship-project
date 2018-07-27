package edu.inconcept.netflix.service;

import edu.inconcept.netflix.entity.Rating;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface RatingService {
    Rating add(Rating rating);

    List<Rating> bulkInsert(Collection<Rating> ratingList);
}

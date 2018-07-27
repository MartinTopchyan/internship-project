package edu.inconcept.netflix.service;

import edu.inconcept.netflix.entity.TitleType;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface TitleTypeService {
    TitleType findTitleTypeByName(String titleType);

    TitleType save(TitleType titleType);

    List<TitleType> bulkInsert(Collection<TitleType> values);
}

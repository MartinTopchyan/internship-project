package edu.inconcept.netflix.service.impl;

import edu.inconcept.netflix.entity.TitleType;
import edu.inconcept.netflix.repository.TitleTypeRepository;
import edu.inconcept.netflix.service.TitleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class TitleTypeServiceImpl implements TitleTypeService {
    @Autowired
    TitleTypeRepository titleTypeRepository;


    @Override
    public TitleType findTitleTypeByName(String titleType){
        return titleTypeRepository.findByName(titleType);
    }

    @Override
    public TitleType save(TitleType titleType) {
        return titleTypeRepository.save(titleType);
    }

    @Override
    public List<TitleType> bulkInsert(Collection<TitleType> values) {
        return titleTypeRepository.saveAll(values);
    }
}

package edu.inconcept.netflix.repository;

import edu.inconcept.netflix.entity.TitleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleTypeRepository extends JpaRepository<TitleType,Long> {
    TitleType findByName(String name);
}

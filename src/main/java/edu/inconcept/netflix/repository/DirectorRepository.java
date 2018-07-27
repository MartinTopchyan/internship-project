package edu.inconcept.netflix.repository;

import edu.inconcept.netflix.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Long> {

    Director findByName(String name);
}

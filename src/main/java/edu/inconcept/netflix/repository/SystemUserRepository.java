package edu.inconcept.netflix.repository;

import edu.inconcept.netflix.entity.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser,Long> {

    Optional<SystemUser> findByName(String userName);
}

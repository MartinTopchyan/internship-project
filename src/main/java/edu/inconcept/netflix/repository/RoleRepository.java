package edu.inconcept.netflix.repository;

import edu.inconcept.netflix.entity.SystemRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<SystemRole, Long> {
}

package edu.supavenir.ormtest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.supavenir.ormtest.models.Organization;

public interface OrgaRepository extends JpaRepository<Organization, Integer> {
    List<Organization> findByDomain(String domain);

    List<Organization> findByName(String name);

}

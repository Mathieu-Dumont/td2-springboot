package edu.supavenir.ormtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.supavenir.ormtest.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

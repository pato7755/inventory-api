package com.afrifanom.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserId(String id);

    String findRoleByUserId(String id);

}

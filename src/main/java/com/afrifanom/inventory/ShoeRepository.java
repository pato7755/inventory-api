package com.afrifanom.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface ShoeRepository extends JpaRepository<Shoe, Integer> {

    List<Shoe> findAll();

    Shoe findById(String id);


}
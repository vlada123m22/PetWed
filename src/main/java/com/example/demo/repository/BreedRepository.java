package com.example.demo.repository;

import com.example.demo.entity.Breeds;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BreedRepository extends CrudRepository<Breeds, Integer> {
    @Query("SELECT b FROM Breeds b WHERE b.breed= :breed")
    Breeds getByName(String breed);
    @Query("SELECT b FROM Breeds b WHERE b.species= :species")
    List<Breeds> getBySpecies(String species);
}

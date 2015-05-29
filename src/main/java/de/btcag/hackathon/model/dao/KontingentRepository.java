package de.btcag.hackathon.model.dao;

import org.springframework.data.repository.CrudRepository;

import de.btcag.hackathon.model.Kontingent;

public interface KontingentRepository extends CrudRepository<Kontingent, Integer> {
}
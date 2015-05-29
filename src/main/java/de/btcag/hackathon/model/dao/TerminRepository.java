package de.btcag.hackathon.model.dao;

import org.springframework.data.repository.CrudRepository;

import de.btcag.hackathon.model.Termin;

public interface TerminRepository extends CrudRepository<Termin, Integer> {
}
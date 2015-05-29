package de.btcag.hackathon.Boundary;

import de.btcag.hackathon.model.Termin;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(path="termine")
public interface TerminRestRepository extends Repository<Termin, Integer> {

    public List<Termin> findAll();

    public List<Termin> findByDatum(@Param("datum") String datum);
}
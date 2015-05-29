package de.btcag.hackathon.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.btcag.hackathon.model.Termin;
import de.btcag.hackathon.model.dao.KontingentRepository;
import de.btcag.hackathon.model.dao.TerminRepository;

@Service
public class ReservationService {

	@Autowired
	private TerminRepository terminRepository;

	@Autowired
	private KontingentRepository kontingentRepository;
	
	public List<Termin> getTermine() {
		return (List<Termin>) terminRepository.findAll();
	}
	
	public Termin addTermin(Termin termin) {
		return terminRepository.save(termin);
	}

}
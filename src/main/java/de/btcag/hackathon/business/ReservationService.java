package de.btcag.hackathon.business;

import java.util.List;

import org.joda.time.DateTime;
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
		DateTime now = DateTime.now();
		if(now.plusDays(9).isBefore(termin.getDatum().getTime())) {
			return terminRepository.save(termin);	
		}
		throw new IllegalArgumentException();
	}
	
	public Termin getAsapTermin() {
		Termin termin = new Termin();
		termin.setDatum(DateTime.now().plusDays(10).toDate());
		return termin; 
	}

}
package de.btcag.hackathon.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.btcag.hackathon.model.Termin;
import de.btcag.hackathon.model.dao.KontingentRepository;
import de.btcag.hackathon.model.dao.TerminRepository;

@RestController
@RequestMapping(value = "termine")
public class ReservationService {

	@Autowired
	private TerminRepository terminRepository;

	@Autowired
	private KontingentRepository kontingentRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Termin> getTermine() {
		return (List<Termin>) terminRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Termin addTermin(@RequestBody Termin termin) {
		return terminRepository.save(termin);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Termin> update(@RequestBody Termin termin){
		if(terminRepository.findOne(termin.getId())!=null) {
			return new ResponseEntity<Termin>(terminRepository.save(termin),HttpStatus.OK);
		}{
			return new ResponseEntity<Termin>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestBody Termin termin){
		terminRepository.delete(termin);
	}
}
package de.btcag.hackathon.rest;

import java.util.List;

import de.btcag.hackathon.model.dao.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.btcag.hackathon.business.ReservationService;
import de.btcag.hackathon.model.Termin;

@RestController
@RequestMapping(value = "termine")
public class ReservationRest {
	
	@Autowired
	private ReservationService reservationService;

    @Autowired
    private TerminRepository terminRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Termin> getTermine() {
		return (List<Termin>) reservationService.getTermine();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Termin addTermin(@RequestBody Termin termin) {
		return reservationService.addTermin(termin);
	}

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Termin> update(@RequestBody Termin termin){
        if(terminRepository.findOne(termin.getId())!=null) {
            return new ResponseEntity<Termin>(terminRepository.save(termin), HttpStatus.OK);
        }{
            return new ResponseEntity<Termin>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity delete(@RequestBody Termin termin){
        if(terminRepository.findOne(termin.getId())!= null) {
            terminRepository.delete(termin);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

}

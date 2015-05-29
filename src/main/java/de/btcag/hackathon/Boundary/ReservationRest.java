package de.btcag.hackathon.Boundary;

import de.btcag.hackathon.model.dao.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import de.btcag.hackathon.business.ReservationService;
import de.btcag.hackathon.model.Termin;

@RestController
@RequestMapping(value = "termine/reservierung")
public class ReservationRest {
	
	@Autowired
	private ReservationService reservationService;

    @Autowired
    private TerminRepository terminRepository;

	@RequestMapping(method = RequestMethod.POST)
	public Termin addTermin(@RequestBody Termin termin) {
		return reservationService.addTermin(termin);
	}

    @RequestMapping( method = RequestMethod.GET)
    public Termin find(@RequestParam()Integer id) {
        return terminRepository.findOne(id);
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

package de.btcag.hackathon.boundary;

import de.btcag.hackathon.model.dao.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}

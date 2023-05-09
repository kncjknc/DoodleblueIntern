package PassengerVSTickets.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import PassengerVSTickets.entity.Passengers;
import PassengerVSTickets.model.TicketResponse;
import PassengerVSTickets.service.PassengersServiceClass;

@RestController
public class CommonController {


	@Autowired
	private PassengersServiceClass passengersServiceClass;

	@PostMapping("/bookTiket")
	public Passengers createTicket(@RequestBody Passengers Passengers) {
		return passengersServiceClass.createTicket(Passengers);
	}

	@GetMapping("/getAllPassengers")
	public List<Passengers> findAllPassengers() {
		return passengersServiceClass.getPassengers();
	}
	
	
	 

}

package PassengerVSTickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PassengerVSTickets.entity.Passengers;
import PassengerVSTickets.model.PassengerRequest;
import PassengerVSTickets.model.TicketResponse;
import PassengerVSTickets.repository.PassengerRepo;

@Service
public class PassengersServiceClass {
	
	@Autowired
	private PassengerRepo passengerRepo;

	public Passengers createTicket(Passengers Passengers) {
		return passengerRepo.save(Passengers);
			
	}

	public List<Passengers> getPassengers() {
		
		return passengerRepo.findAll();
	}

	
	 
	
	

}

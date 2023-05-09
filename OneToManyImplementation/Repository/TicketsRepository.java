package PassengerVSTickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PassengerVSTickets.entity.Tickets;

@Repository
public interface TicketRepo extends JpaRepository<Tickets, Integer> {

}

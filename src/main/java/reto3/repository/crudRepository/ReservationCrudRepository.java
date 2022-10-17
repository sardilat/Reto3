package reto3.repository.crudRepository;


import org.springframework.data.repository.CrudRepository;
import reto3.model.Reservation;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
}

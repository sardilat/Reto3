package reto3.repository.crudRepository;


import org.springframework.data.repository.CrudRepository;
import reto3.model.Machine;

public interface MachineCrudRepository extends CrudRepository<Machine,Integer> {
}

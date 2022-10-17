package reto3.repository.crudRepository;


import org.springframework.data.repository.CrudRepository;
import reto3.model.Client;

public interface ClientCrudRepository extends CrudRepository<Client,Integer> {
}

package reto3.repository.crudRepository;


import org.springframework.data.repository.CrudRepository;
import reto3.model.Message;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}

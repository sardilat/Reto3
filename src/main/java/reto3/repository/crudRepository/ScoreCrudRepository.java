package reto3.repository.crudRepository;


import org.springframework.data.repository.CrudRepository;
import reto3.model.Score;

public interface ScoreCrudRepository extends CrudRepository<Score,Integer> {
}

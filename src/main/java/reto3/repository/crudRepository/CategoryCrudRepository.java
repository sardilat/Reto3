package reto3.repository.crudRepository;


import org.springframework.data.repository.CrudRepository;
import reto3.model.Category;

public interface CategoryCrudRepository extends CrudRepository<Category,Integer> {
}

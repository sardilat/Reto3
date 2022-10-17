package reto3.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.model.Category;
import reto3.repository.crudRepository.CategoryCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

     public List<Category> getAll(){
         return (List<Category>) categoryCrudRepository.findAll();
     }

     public Optional<Category> getCategory(int id){
         return categoryCrudRepository.findById(id);
    }

    public Category save(Category category){
         return categoryCrudRepository.save(category);
    }

    public void delete(Category category){ categoryCrudRepository.delete(category);
    }
}

package reto3.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.model.Score;
import reto3.repository.crudRepository.ScoreCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
     @Autowired
     private ScoreCrudRepository scoreCrudRepository;

     public List<Score> getAll(){
         return (List<Score>)scoreCrudRepository.findAll();
     }

     public Optional<Score> getScore(int idScore){
          return scoreCrudRepository.findById(idScore);
     }

     public Score save(Score s){
          return scoreCrudRepository.save(s);
     }

     public void delete(Score s){
          scoreCrudRepository.delete(s);
     }


}

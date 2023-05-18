package ioj.judge.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import ioj.judge.entities.Problem;

public interface ProblemRepository extends MongoRepository<Problem, String>{
    
}

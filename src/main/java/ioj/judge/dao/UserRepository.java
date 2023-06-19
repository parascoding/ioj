package ioj.judge.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import ioj.judge.entities.User;

public interface UserRepository extends MongoRepository<User, String>{
    
}

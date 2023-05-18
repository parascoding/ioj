package ioj.judge.dao;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ioj.judge.entities.Contest;

public interface ContestRepository extends MongoRepository<Contest, String>{
    // @Query("{}")
    // Page<Contest> findAllPage(Pageable pageable);
}

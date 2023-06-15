package ioj.judge.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ioj.judge.entities.Submission;

public interface SubmissionRepository extends MongoRepository<Submission, Date>{
    public List<Submission> findSubmissionByUserId(String userId);
}

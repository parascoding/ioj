package ioj.judge.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ioj.judge.entities.Submission;

public interface SubmissionRepository extends MongoRepository<Submission, Long>{
    public List<Submission> findSubmissionByUserId(String userId);

    @Query("{userId:?0, contestId:?1, problemId:?2}")
    public List<Submission> findSubmissionByUserIdContestIdProblemId(String userId, String contestId, String problemId);
}

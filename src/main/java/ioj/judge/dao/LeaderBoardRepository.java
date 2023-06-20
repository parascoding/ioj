package ioj.judge.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import ioj.judge.entities.Leaderboard;

public interface LeaderBoardRepository extends MongoRepository<Leaderboard, String>{
    
}

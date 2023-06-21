package ioj.judge.entities;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Leaderboard {
    @Id
    private String contestId;

    private Map<String, Set<String>> userIdToProblemSolvedMap;
    private HashMap<String, Integer> userIdToScoreMap;
    public Leaderboard(String contestId){
        this.contestId = contestId;
        this.userIdToProblemSolvedMap = new HashMap<>();
        this.userIdToScoreMap = new HashMap<>(
            // new Comparator<String>() {
            //     public int compare(String x, String y){
            //         return userIdToScoreMap.getOrDefault(y, 0) - userIdToScoreMap.getOrDefault(x, 0);
            //     }
            // }
        );
    }

    public void userSolved(String userId, String problemId){
        
        if(!userIdToProblemSolvedMap.containsKey(userId))
            userIdToProblemSolvedMap.put(userId,  new  HashSet<>());
        if(userIdToProblemSolvedMap.get(userId).add(problemId)){
            userIdToScoreMap.put(userId, userIdToScoreMap.getOrDefault(userId, 0) + 100);
        }
        System.out.println(userIdToProblemSolvedMap);
        System.out.println(userIdToScoreMap);
    }
}

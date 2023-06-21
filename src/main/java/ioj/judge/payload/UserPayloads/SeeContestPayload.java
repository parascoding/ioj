package ioj.judge.payload.UserPayloads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import ioj.judge.payload.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SeeContestPayload extends ApiResponse{
    private long startTime;
    private long endTime;
    private List<String[]> problemData;
    public SeeContestPayload(){
        problemData = new ArrayList<>();
        
    }
    public void add(String problemId, String difficulty, int solvedCount){
        problemData.add(new String[]{problemId, difficulty, Integer.toString(solvedCount)});
    }
}
class ProblemData{
    String problemId;
    String difficulty;
    int solvedCount;
    ProblemData(String problemId, String difficulty, int solvedCount){
        this.problemId = problemId;
        this.difficulty = difficulty;
        this.solvedCount = solvedCount;
    }
}

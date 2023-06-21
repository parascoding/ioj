package ioj.judge.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;

@Document("Contest")
@Getter
@Setter
@ToString
public class Contest {
    @Id
    private String id;
    private long startTime;
    private long endTime;
    private Set<String> listOfProblems;
    public boolean addProblem(String problemId){
        if(listOfProblems == null)
            listOfProblems = new TreeSet<>();
        listOfProblems.add(problemId);
        return true;
    }
    public boolean deleteProblem(String problemId){
        listOfProblems.remove(problemId);
	    return true;
    }
}

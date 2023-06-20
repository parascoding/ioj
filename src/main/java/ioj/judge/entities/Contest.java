package ioj.judge.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Document("Contest")
@Getter
@Setter
public class Contest {
    @Id
    private String id;
    private Date startTime;
    private Date endTime;
    private List<String> listOfProblems;
    public boolean addProblem(String problemId){
        if(listOfProblems == null)
            listOfProblems = new ArrayList<>();
        listOfProblems.add(problemId);
        return true;
    }
    public boolean deleteProblem(String problemId){
    	List<String> tempList = new ArrayList<>();
    	for(String x : this.listOfProblems)
	    	if(!x.equals(problemId))
	    		tempList.add(x);
	    this.listOfProblems = new ArrayList<>(tempList);
	    return true;
    }
}

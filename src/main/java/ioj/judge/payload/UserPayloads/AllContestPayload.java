package ioj.judge.payload.UserPayloads;

import java.util.List;

import org.springframework.data.domain.Page;

import ioj.judge.entities.Contest;
import ioj.judge.payload.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AllContestPayload extends ApiResponse{
    private List<Contest> listOfContest;        
}

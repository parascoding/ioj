package ioj.judge.payload.UserPayloads;

import java.util.Date;
import java.util.List;


import ioj.judge.payload.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeeContestPayload extends ApiResponse{
    private Date startTime;
    private Date endTime;
    private List<String> listOfProblem;
}

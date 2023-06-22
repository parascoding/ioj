package ioj.judge.payload.UserPayloads;

import java.util.ArrayList;
import java.util.List;

import ioj.judge.payload.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeeManySubmissionPayload extends ApiResponse{
    private List<Long> submissionIds;
    public void addSubmission(long id){
        if(submissionIds == null)
            submissionIds = new ArrayList<>();
        submissionIds.add(id);
    }
}

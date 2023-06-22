package ioj.judge.payload.UserPayloads;

import ioj.judge.entities.Submission;
import ioj.judge.payload.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeeSubmissionPayload extends ApiResponse{
    private Submission submission;
}

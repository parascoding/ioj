package ioj.judge.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubmissionResultPayload extends ApiResponse {
    private String result;
    private String details;
    private long submissionId;
    public SubmissionResultPayload(String result, String details){
        this.result = result;
        this.details = details;
    }
}

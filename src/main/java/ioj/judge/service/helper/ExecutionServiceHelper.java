package ioj.judge.service.helper;

import ioj.judge.payload.SubmissionPayload;

public interface ExecutionServiceHelper {
    
    public boolean executeFile(SubmissionPayload submissionPayload) throws Exception;
}

package ioj.judge.service.helper;

import ioj.judge.payload.SubmissionPayload;

public interface ExecutionServiceHelper {
    public final String basePath = "../../../../../data/";
    public long executeFile(SubmissionPayload submissionPayload) throws Exception;
}

package ioj.judge.service.helper;

import ioj.judge.payload.SubmissionPayload;
import ioj.judge.service.GetbasePathService;

public interface ExecutionServiceHelper {
    // public final String basePath = "../../../../../data/";
    public String basePath = new GetbasePathService().getBasePath();
    public long executeFile(SubmissionPayload submissionPayload) throws Exception;
}

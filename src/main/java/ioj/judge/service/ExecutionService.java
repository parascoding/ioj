package ioj.judge.service;

import ioj.judge.payload.SubmissionPayload;
import ioj.judge.service.helper.ExecutionServiceHelper;
import ioj.judge.service.helper.impl.JavaExecutionServiceHelper;

public class ExecutionService {
    public boolean executeFile(SubmissionPayload submissionPayload) throws Exception{
        try {
            ExecutionServiceHelper executionServiceHelper = new JavaExecutionServiceHelper();
            return executionServiceHelper.executeFile(submissionPayload);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

package ioj.judge.service;

import ioj.judge.payload.SubmissionPayload;
import ioj.judge.service.helper.ExecutionServiceHelper;
import ioj.judge.service.helper.impl.CppExecutionServiceHelperImpl;
import ioj.judge.service.helper.impl.JavaExecutionServiceHelperImpl;

public class ExecutionService {
    public boolean executeFile(SubmissionPayload submissionPayload) throws Exception{
        try {
            ExecutionServiceHelper executionServiceHelper;
            if(submissionPayload.getLanguage().equals("java"))
                executionServiceHelper = new JavaExecutionServiceHelperImpl();
            else
                executionServiceHelper = new CppExecutionServiceHelperImpl();
            return executionServiceHelper.executeFile(submissionPayload);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

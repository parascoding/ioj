package ioj.judge.service.helper;

import ioj.judge.payload.SubmissionPayload;

public interface CompileFileServiceHelper {
    public boolean compileFile(SubmissionPayload submissionPayload) throws Exception;
}

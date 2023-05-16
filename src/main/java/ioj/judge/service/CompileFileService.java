package ioj.judge.service;

import ioj.judge.payload.SubmissionPayload;
import ioj.judge.service.helper.CompileFileServiceHelper;
import ioj.judge.service.helper.impl.JavaCompileFileServiceHelperImpl;

public class CompileFileService {
    public boolean compileFile(SubmissionPayload submissionPayload) throws Exception{
        try {
            CompileFileServiceHelper compileFileServiceHelper = new JavaCompileFileServiceHelperImpl();
            return compileFileServiceHelper.compileFile(submissionPayload);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

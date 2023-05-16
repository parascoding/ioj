package ioj.judge.service;

import ioj.judge.payload.SubmissionPayload;
import ioj.judge.service.helper.CompileFileServiceHelper;
import ioj.judge.service.helper.impl.CppCompileFileServiceHelperImpl;
import ioj.judge.service.helper.impl.JavaCompileFileServiceHelperImpl;

public class CompileFileService {
    public boolean compileFile(SubmissionPayload submissionPayload) throws Exception{
        try {
            CompileFileServiceHelper compileFileServiceHelper;
            if(submissionPayload.getLanguage().equals("java"))
                compileFileServiceHelper = new JavaCompileFileServiceHelperImpl();
            else// if(submissionPayload.getLanguage().equals("cpp"))
                compileFileServiceHelper = new CppCompileFileServiceHelperImpl();
            return compileFileServiceHelper.compileFile(submissionPayload);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

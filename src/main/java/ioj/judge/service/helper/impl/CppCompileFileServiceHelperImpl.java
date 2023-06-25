package ioj.judge.service.helper.impl;

import ioj.judge.payload.SubmissionPayload;
import ioj.judge.service.helper.CompileFileServiceHelper;

public class CppCompileFileServiceHelperImpl implements CompileFileServiceHelper{

    @Override
    public boolean compileFile(SubmissionPayload submissionPayload) throws Exception{
        try {
            ProcessBuilder pb = new ProcessBuilder(
                "g++",
                "-o",
                submissionPayload.getFilePath(),
                submissionPayload.getFilePath()+".cpp"
            );
            // System.out.println(submissionPayload.getFilePath());
            Process p = pb.start();
            int s = p.waitFor();
            if (s != 0) {
                // System.out.println("Compile Error");
                return false;
            } else {
                // System.out.println("Compilation successful");
                return true;    
            }
        } catch (Exception e) {
            // System.out.println(e.getMessage());
            return false;   
        }

    }
    
}

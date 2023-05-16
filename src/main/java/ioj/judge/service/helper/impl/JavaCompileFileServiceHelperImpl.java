package ioj.judge.service.helper.impl;

import ioj.judge.payload.SubmissionPayload;
import ioj.judge.service.helper.CompileFileServiceHelper;

public class JavaCompileFileServiceHelperImpl implements CompileFileServiceHelper{
    private String basePath = "/mnt/32b6b06a-25ad-4911-90a2-9c68b656b0e3/Personal/Spring/judge/data/";
    @Override
    public boolean compileFile(SubmissionPayload submissionPayload) throws Exception{
        try {
            ProcessBuilder pb = new ProcessBuilder("javac", submissionPayload.getFilePath()+".java");
            Process p = pb.start();
            int s = p.waitFor();
            if (s != 0) {
                System.out.println("Compile Error");
                return true;
            } else {
                System.out.println("Compilation successful");
                return true;    
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;   
        }

    }
    
}

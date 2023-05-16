package ioj.judge.service.helper.impl;

import java.io.InputStream;

import ioj.judge.payload.SubmissionPayload;
import ioj.judge.service.helper.ExecutionServiceHelper;

public class JavaExecutionServiceHelper implements ExecutionServiceHelper{
    private String basePath = "/mnt/32b6b06a-25ad-4911-90a2-9c68b656b0e3/Personal/Spring/judge/data/";
    @Override
    public boolean executeFile(SubmissionPayload submissionPayload) throws Exception {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", submissionPayload.getFilePath()+".java", basePath+submissionPayload.getContestId()+"/"+submissionPayload.getProblemId()+"/problem/input.txt", basePath+submissionPayload.getContestId()+"/"+submissionPayload.getProblemId()+"/"+submissionPayload.getUserId()+"/output.txt");
            Process p = pb.start();
            int compileExitCode = p.waitFor();

            // If the exit code is not 0, the compilation failed.
            if (compileExitCode != 0) {
                // Get the error stream of the compiler process.
                InputStream errorStream = p.getErrorStream();

                // Read the error messages from the stream and print them to the console.
                byte[] buf = new byte[1024];
                int bytesRead;
                while ((bytesRead = errorStream.read(buf)) != -1) {
                    System.err.print(new String(buf, 0, bytesRead));
                }
            } else {
                System.out.println("Run successful");
            }
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
}

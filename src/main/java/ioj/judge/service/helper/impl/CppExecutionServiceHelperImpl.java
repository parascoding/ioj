package ioj.judge.service.helper.impl;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import ioj.judge.payload.SubmissionPayload;
import ioj.judge.service.helper.ExecutionServiceHelper;

public class CppExecutionServiceHelperImpl implements ExecutionServiceHelper{
    // private String basePath = "../../../../../data/";
    @Override
    public long executeFile(SubmissionPayload submissionPayload) throws Exception {
        try {
            ProcessBuilder pb = new ProcessBuilder(submissionPayload.getFilePath(), basePath+submissionPayload.getContestId()+"/"+submissionPayload.getProblemId()+"/problem/input.txt", basePath+submissionPayload.getContestId()+"/"+submissionPayload.getProblemId()+"/"+submissionPayload.getUserId()+"/output.txt");
    
            System.out.println(submissionPayload.getFilePath()+"\n"+basePath+submissionPayload.getContestId()+"/"+submissionPayload.getProblemId()+"/problem/input.txt"+"\n"+basePath+submissionPayload.getContestId()+"/"+submissionPayload.getProblemId()+"/"+submissionPayload.getUserId()+"/output.txt");
    
            long currentTime = System.currentTimeMillis();
            Process p = pb.start();
            boolean compileExitCode = p.waitFor(1, TimeUnit.SECONDS);
            long endTime = System.currentTimeMillis();
            long timeTaken = (endTime-currentTime);
            // If the exit code is not 0, the compilation failed.
            if(p.isAlive()){
                throw new Exception("Time Limit Exceeded");
            }
            if (!compileExitCode) {
                // Get the error stream of the compiler process.
                InputStream errorStream = p.getErrorStream();
    
                // Read the error messages from the stream and print them to the console.
                byte[] buf = new byte[1024];
                int bytesRead;
                while ((bytesRead = errorStream.read(buf)) != -1) {
                    System.err.print(new String(buf, 0, bytesRead));
                }
                return -1;
            } else {
                System.out.println("Run successful");
            }
            return timeTaken;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
    
}

package ioj.judge.service.helper.impl;

import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.time.Duration;
import java.time.Instant;

import ioj.judge.payload.SubmissionPayload;
import ioj.judge.service.helper.ExecutionServiceHelper;
import java.util.concurrent.TimeUnit;

public class JavaExecutionServiceHelperImpl implements ExecutionServiceHelper{
    private String basePath = "/mnt/32b6b06a-25ad-4911-90a2-9c68b656b0e3/Personal/Spring/judge/data/";
    @Override
    public boolean executeFile(SubmissionPayload submissionPayload) throws Exception {
        try {

           
            ProcessBuilder pb = new ProcessBuilder("java", submissionPayload.getFilePath()+".java", basePath+submissionPayload.getContestId()+"/"+submissionPayload.getProblemId()+"/problem/input.txt", basePath+submissionPayload.getContestId()+"/"+submissionPayload.getProblemId()+"/"+submissionPayload.getUserId()+"/output.txt");
            Process p = pb.start();
            ProcessHandle processHandle = p.toHandle();
            ProcessHandle.Info info = processHandle.info();
            boolean compileExitCode = p.waitFor(1, TimeUnit.SECONDS);
            

            Duration duration = info.totalCpuDuration().orElse(Duration.ZERO);
            System.out.println(info.toString()+" "+info.startInstant().get().toString()+" "+info.totalCpuDuration().get().toString()+" "+duration.toNanos());
			if(p.isAlive()){
				throw new Exception("Time Limit Exceeded");
			}
            // If the exit code is not 0, the compilation failed.
            if (!compileExitCode) {
                // Get the error stream of the compile process.
                InputStream errorStream = p.getErrorStream();

                // Read the error messages from the stream and print them to the console.
                byte[] buf = new byte[1024];
                int bytesRead;
                while ((bytesRead = errorStream.read(buf)) != -1) {
                    System.err.print(new String(buf, 0, bytesRead));
                }
                return false;
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

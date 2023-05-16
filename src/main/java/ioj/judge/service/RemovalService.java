package ioj.judge.service;

import org.apache.catalina.valves.ExtendedAccessLogValve;

import ioj.judge.payload.SubmissionPayload;

public class RemovalService {
    private String basePath = "/mnt/32b6b06a-25ad-4911-90a2-9c68b656b0e3/Personal/Spring/judge/data/";
    public boolean removeTempFiles(SubmissionPayload submissionPayload) throws Exception{
        try {
            ProcessBuilder pb = new ProcessBuilder(
                "rm",
                "-rf",
                basePath+submissionPayload.getContestId()+"/"+
                submissionPayload.getProblemId()+"/"+
                submissionPayload.getUserId()
            );
            Process p = pb.start();
            int waitCode = p.waitFor();
            int exitCode = p.exitValue();
            return exitCode == 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e);
        }
    }
}

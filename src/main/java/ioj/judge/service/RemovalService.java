package ioj.judge.service;

import org.apache.catalina.valves.ExtendedAccessLogValve;

import ioj.judge.payload.SubmissionPayload;

public class RemovalService {
    private String basePath = "../../../../../data/";
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
            // System.out.println("REMOVAL EXIT CODE: "+exitCode);
            return exitCode == 0;
        } catch (Exception e) {
            // System.out.println(e.getMessage());
            throw new Exception(e);
        }
    }
}

package ioj.judge.service;

import java.io.File;
import ioj.judge.payload.ApiResponse;
import ioj.judge.payload.SubmissionPayload;
import ioj.judge.payload.SubmissionResultPayload;

public class SubmissionService {
    private SaveToFileService saveToFileService;
    private CompileFileService compileFileService;
    private ExecutionService executionService;
    private MatcherService matcherService;
    private RemovalService removalService;
    public SubmissionService(){
        saveToFileService = new SaveToFileService();
        compileFileService = new CompileFileService();
        executionService = new ExecutionService();
        matcherService = new MatcherService();
        removalService = new RemovalService();
    }
    public SubmissionResultPayload submission(SubmissionPayload submissionPayload) throws Exception{
        try {
            // System.out.println("GOING TO SAVE");
            if(!saveToFileService.saveToFile(submissionPayload)){
                removalService.removeTempFiles(submissionPayload);
                return new SubmissionResultPayload(
                    "SE",
                    "Saving Error"
                );
            }
            // System.out.println("SAVED");
            if(!compileFileService.compileFile(submissionPayload)){
                removalService.removeTempFiles(submissionPayload);
                return new SubmissionResultPayload(
                    "CE",
                    "Compilation Error"
                );
            }
            // System.out.println("Compiled");
            long timeTaken = executionService.executeFile(submissionPayload);
            // System.out.println("Runned");
            if(timeTaken == -1){
                removalService.removeTempFiles(submissionPayload);
                return new SubmissionResultPayload(
                    "RE",
                    "Runtime Error/Time Limit Exceeded"
                );
            }
            if(!matcherService.matchOutput(
                new File(submissionPayload.getBasePath() + "problem/output.txt"),
                new File(submissionPayload.getBasePath() + submissionPayload.getUserId() + "/output.txt")
            )){
                removalService.removeTempFiles(submissionPayload);
                return new SubmissionResultPayload(
                    "WA",
                    "Wrong Answer"
                );
            }
            removalService.removeTempFiles(submissionPayload);
            SubmissionResultPayload submissionResultPayload = new SubmissionResultPayload("AC", "Accepted");
            submissionResultPayload.setIsSuccess(true);
            submissionResultPayload.setTimeTaken(timeTaken);
            return submissionResultPayload;
            
        } catch (Exception e) {
            throw new Exception("HERE:"+e.getMessage());
        }
    }
}

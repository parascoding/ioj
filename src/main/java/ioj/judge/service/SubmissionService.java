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
    public ApiResponse submission(SubmissionPayload submissionPayload) throws Exception{
        try {
            if(!saveToFileService.saveToFile(submissionPayload)){
                return new SubmissionResultPayload(
                    "SE",
                    "Saving Error"
                );
            }
            
            if(!compileFileService.compileFile(submissionPayload)){
                return new SubmissionResultPayload(
                    "CE",
                    "Compilation Error"
                );
            }

            if(!executionService.executeFile(submissionPayload)){
                return new SubmissionResultPayload(
                    "RE",
                    "Runtime Error/Time Limit Exceeded"
                );
            }
            if(!matcherService.matchOutput(
                new File(submissionPayload.getBasePath() + "problem/output.txt"),
                new File(submissionPayload.getBasePath() + submissionPayload.getUserId() + "/output.txt")
            )){
                return new SubmissionResultPayload(
                    "WA",
                    "Wrong Answer"
                );
            }
            removalService.removeTempFiles(submissionPayload);
            SubmissionResultPayload submissionResultPayload = new SubmissionResultPayload("AC", "Accepted");
            submissionResultPayload.setIsSuccess(true);
            return submissionResultPayload;
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

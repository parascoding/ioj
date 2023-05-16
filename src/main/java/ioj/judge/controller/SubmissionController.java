package ioj.judge.controller;

import java.io.File;
import ioj.judge.payload.SubmissionPayload;
import ioj.judge.payload.SubmissionResultPayload;
import ioj.judge.service.CompileFileService;
import ioj.judge.service.ExecutionService;
import ioj.judge.service.MatcherService;
import ioj.judge.service.SaveToFileService;

public class SubmissionController {
    private SaveToFileService saveToFileService;
    private CompileFileService compileFileService;
    private ExecutionService executionService;
    private MatcherService matcherService;
    public SubmissionController(){
        saveToFileService = new SaveToFileService();
        compileFileService = new CompileFileService();
        executionService = new ExecutionService();
        matcherService = new MatcherService();
    }
    public SubmissionResultPayload submission(SubmissionPayload submissionPayload) throws Exception{
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
                    "Runtime Error"
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
            return new SubmissionResultPayload(
                "AC",
                "Accepted"
            );
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

package ioj.judge.controller;

import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ioj.judge.dao.SubmissionRepository;
import ioj.judge.entities.Submission;
import ioj.judge.payload.ApiResponse;
import ioj.judge.payload.SubmissionPayload;
import ioj.judge.payload.SubmissionResultPayload;
import ioj.judge.service.SubmissionService;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("compete/{contestId}/{problemId}/")
@CrossOrigin("*")
public class SubmissionController {
    private SubmissionService submissionService;
    public SubmissionController(){
        submissionService = new SubmissionService();
    }
    
    @Autowired
    private SubmissionRepository submissionRepository;

    @PostMapping("submit")
    public ApiResponse submit(@ModelAttribute SubmissionPayload submissionPayload) throws Exception{
        Submission submission = new Submission();
        try {
            submission.setTimeStamp(submissionPayload.getTimeStamp());
            submission.setUserId(submissionPayload.getUserId());
            ApiResponse apiResponse = submissionService.submission(submissionPayload);
            submission.setResult("ACCEPTED");
            submissionRepository.save(submission);
            return apiResponse;
        } catch (Exception e) {
            submission.setResult(e.getMessage());
            submissionRepository.save(submission);
            return new ApiResponse(false, e.getMessage());
        }
    }
    
    @PostMapping("submitCode")
    public ApiResponse submitCode(MultipartFile srcCode, @PathVariable String contestId, @PathVariable String problemId) throws Exception{
        try {
        	SubmissionPayload submissionPayload = new SubmissionPayload();
        	submissionPayload.setContestId(contestId);
        	submissionPayload.setProblemId(problemId);
        	submissionPayload.setUserId("parascoding");
        	submissionPayload.setLanguage("java");
        	submissionPayload.setSourceCode(srcCode);
            return submissionService.submission(submissionPayload);
        } catch (Exception e) {
            return new ApiResponse(false, e.getMessage());
        }
    }
    
}

package ioj.judge.controller;

import java.io.File;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ioj.judge.payload.ApiResponse;
import ioj.judge.payload.SubmissionPayload;
import ioj.judge.payload.SubmissionResultPayload;
import ioj.judge.service.SubmissionService;


@RestController
@RequestMapping("compete/{contestId}/{problemId}/")
public class SubmissionController {
    private SubmissionService submissionService;
    public SubmissionController(){
        submissionService = new SubmissionService();
    }
    @PostMapping("submit")
    public ApiResponse submit(@ModelAttribute SubmissionPayload submissionPayload) throws Exception{
        try {
            return submissionService.submission(submissionPayload);
        } catch (Exception e) {
            return new ApiResponse(false, e.getMessage());
        }
    }
    
}
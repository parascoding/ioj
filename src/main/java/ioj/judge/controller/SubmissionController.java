package ioj.judge.controller;

import java.io.File;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ioj.judge.dao.ContestRepository;
import ioj.judge.dao.LeaderBoardRepository;
import ioj.judge.dao.ProblemRepository;
import ioj.judge.dao.SubmissionRepository;
import ioj.judge.entities.Leaderboard;
import ioj.judge.entities.Problem;
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
    private ContestRepository  contestRepository;
    @Autowired
    private SubmissionRepository submissionRepository;
    @Autowired
    private ProblemRepository problemRepository;
    @Autowired
    private LeaderBoardRepository leaderBoardRepository;

    @PostMapping("submit")
    public ApiResponse submit(@ModelAttribute SubmissionPayload submissionPayload, @PathVariable String problemId,  Principal principal) throws Exception{

        Submission submission = new Submission();
        submission.setTimeStamp(System.currentTimeMillis());
        try {
            submission.setTimeStamp(submissionPayload.getTimeStamp());
            submission.setUserId(submissionPayload.getUserId());
            ApiResponse apiResponse = submissionService.submission(submissionPayload);
            submission.setResult("ACCEPTED");
            
            //  Uncomment this later.
            // if(System.currentTimeMillis() <= contestRepository.findById(submissionPayload.getContestId()).get().getEndTime()){
                if(!leaderBoardRepository.existsById(submissionPayload.getContestId()))
                    leaderBoardRepository.save(new Leaderboard(submissionPayload.getContestId()));
                Leaderboard leaderboard = leaderBoardRepository.findById(submissionPayload.getContestId()).get();
    
                leaderboard.userSolved(submission.getUserId(), problemId);
                leaderBoardRepository.save(leaderboard);    
            // }
            Problem problem = problemRepository.findById(problemId).get();
            problem.setSolvedCount(problem.getSolvedCount() + 1);
            problemRepository.save(problem);
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

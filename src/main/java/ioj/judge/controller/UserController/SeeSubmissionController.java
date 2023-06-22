package ioj.judge.controller.UserController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ioj.judge.dao.SubmissionRepository;
import ioj.judge.entities.Contest;
import ioj.judge.entities.Submission;
import ioj.judge.payload.ApiResponse;
import ioj.judge.payload.UserPayloads.SeeManySubmissionPayload;
import ioj.judge.payload.UserPayloads.SeeSubmissionPayload;

@RestController
@RequestMapping("/user/submission/")
@CrossOrigin("*")
public class SeeSubmissionController {
    @Autowired
    private SubmissionRepository submissionRepository;
    

    @GetMapping("{submissionId}")
    private ApiResponse seeUniqueSubmission(@PathVariable String submissionId) throws Exception{
        try {
            long id = Long.parseLong(submissionId);
            SeeSubmissionPayload seeSubmissionPayload = new SeeSubmissionPayload();
            Submission submission = submissionRepository.findById(id).get();
            seeSubmissionPayload.setSubmission(submission);
            seeSubmissionPayload.setIsSuccess(true);
            seeSubmissionPayload.setMessage("Submission Fetched");
            return seeSubmissionPayload;
        } catch (Exception e) {
            return new ApiResponse(false, "No Submission Found");
        }
    }

    @GetMapping("{userId}/{contestId}/{problemId}")
    private ApiResponse seeAllSubmissionUserIdContestIdProblemId(@PathVariable String userId, @PathVariable String contestId, @PathVariable String problemId){
        try {
            List<Submission> submissions = submissionRepository.findSubmissionByUserIdContestIdProblemId(userId, contestId, problemId);
            SeeManySubmissionPayload result = new SeeManySubmissionPayload();
            for(Submission submission : submissions){
                result.addSubmission(submission.getId());
            }
            Collections.reverse(result.getSubmissionIds());
            result.setIsSuccess(true);
            result.setMessage("Submissions Found");
            return result;
        } catch (Exception e) {
            return new ApiResponse(false, "No Sbumission Found");
        }
    }
}

package ioj.judge.controller.UserController;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ioj.judge.dao.ProblemRepository;
import ioj.judge.entities.Problem;
import ioj.judge.payload.ApiResponse;
import ioj.judge.payload.UserPayloads.SeeProblemPayload;
import ioj.judge.service.FetchFileService;
import ioj.judge.service.FetchProblemStatement;

@RestController
@RequestMapping("compete/{contestId}/{problemId}/")
public class SeeProblemController {
    @Autowired
    private ProblemRepository problemRepository;
    
    private FetchProblemStatement fetchFileService;
    
    public SeeProblemController(){
        fetchFileService = new FetchProblemStatement();
    }
    @PostMapping("view")
    private ApiResponse viewProblem(@PathVariable String contestId,
                                    @PathVariable String problemId) throws Exception{
        try {
            Problem problem = problemRepository.findById(problemId).get();
            if(problem == null || !problem.getContestId().equals(contestId)){
                throw new Exception("Problem Not Found");
            }
            File file = fetchFileService.fetchProblemStatement(contestId, problemId);
            SeeProblemPayload seeProblemPayload = new SeeProblemPayload(file);
            seeProblemPayload.setIsSuccess(true);
            return seeProblemPayload;
        } catch (Exception e) {
            return new ApiResponse(false, e.getMessage());
        }
    }
}

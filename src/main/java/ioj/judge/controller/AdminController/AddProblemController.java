package ioj.judge.controller.AdminController;


import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ioj.judge.dao.ContestRepository;
import ioj.judge.dao.ProblemRepository;
import ioj.judge.entities.Contest;
import ioj.judge.entities.Problem;
import ioj.judge.payload.ApiResponse;
import ioj.judge.service.AddProblemService;

@RestController
@RequestMapping("/admin")
public class AddProblemController {

    private AddProblemService addProblemService;
    private String basePath = "/mnt/32b6b06a-25ad-4911-90a2-9c68b656b0e3/Personal/Spring/judge/data/";
    
    @Autowired
    private ContestRepository contestRepository;

    @Autowired
    private ProblemRepository problemRepository;

    @PostMapping("/{contestId}/{problemId}/addProblemFiles")
    public ApiResponse addProblemFiles(MultipartFile problemStatement,
                                MultipartFile inputFile,
                                MultipartFile outputFile,
                                @PathVariable String contestId,
                                @PathVariable String problemId) throws Exception{
        try {
            String path = basePath + contestId + "/" + problemId + "/" + "problem/";
            addProblemService = new AddProblemService();
            if( 
                addProblemService.saveProblemStatement(problemStatement, path) &&
                addProblemService.saveInputFile(inputFile, path) &&
                addProblemService.saveOutputFile(outputFile, path)
            ) return new ApiResponse(true, "Files Saved Successfully");
            throw new Exception("File Can't be Saved");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ApiResponse(false, e.getMessage());
        }
    }



    @PostMapping("/{contestId}/createProblem")
    public ApiResponse createProblem(@PathVariable String contestId, String problemId) throws Exception{
        try {
            Problem problem = new Problem();
            Contest contest = contestRepository.findById(contestId).get();
            if(contest == null)
                throw new Exception("Contest Not Found");
            problem.setId(problemId);
            problem.setContestId(contestId);
            problemRepository.save(problem);
            contest.addProblem(problemId);
            contestRepository.save(contest);
            return new ApiResponse(true, "Problem Created Successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ApiResponse(false, e.getMessage());
        }
    }
    
}

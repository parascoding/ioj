package ioj.judge.controller.AdminController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy.Provider;

import ioj.judge.dao.ContestRepository;
import ioj.judge.dao.ProblemRepository;
import ioj.judge.entities.Contest;
import ioj.judge.entities.Problem;
import ioj.judge.payload.ApiResponse;
import ioj.judge.payload.AdminPayload.AddProblemFilesPayload;
import ioj.judge.service.AddProblemService;
import ioj.judge.service.GetbasePathService;

import org.springframework.web.bind.annotation.ModelAttribute;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AddProblemController {

    private AddProblemService addProblemService;
    // private String basePath = "../../../../../data/";
    private String basePath = new GetbasePathService().getBasePath();
    @Autowired
    private ContestRepository contestRepository;

    @Autowired
    private ProblemRepository problemRepository;

    @PostMapping("/{contestId}/{problemId}/createProblem")
    public ApiResponse addProblem(@PathVariable String contestId, @PathVariable String problemId) throws Exception{
    	try{
    		Problem problem = new Problem();
    		problem.setId(problemId);
    		problem.setContestId(contestId);
    		problemRepository.save(problem);
    		Contest contest = contestRepository.findById(contestId).get();
    		contest.addProblem(problemId);
    		contestRepository.save(contest);
    		return new ApiResponse(true, "Problem Added Succesfully");
    	} catch(Exception e){
    		return new ApiResponse(false, e.getMessage());
    	}
    }
    @PostMapping("/{contestId}/{problemId}/deleteProblem")
    public ApiResponse deleteProblem(@PathVariable String contestId, @PathVariable String problemId) throws Exception{
    	try{
    		Contest contest = contestRepository.findById(contestId).get();
            // // System.out.println(problemId);
            // // System.out.println("BEFORE REMOVING: "+contest);
    		contest.deleteProblem(problemId);
            // // System.out.println("AFTER REMOVING: "+contest);
    		contestRepository.save(contest);
    		problemRepository.deleteById(problemId);
    		return new ApiResponse(true, "Problem Deleted Succesfully");
    	} catch(Exception e){
    		return new ApiResponse(false, e.getMessage());
    	}
    }
    @PostMapping("/{contestId}/{problemId}/addProblemFiles")
    public ApiResponse addProblemFiles(@ModelAttribute AddProblemFilesPayload addProblemFilesPayload,
                                @PathVariable String contestId,
                                @PathVariable String problemId) throws Exception{
        try {
            // // System.out.println(contestId+" "+problemId);
            String path = basePath + contestId + "/" + problemId + "/" + "problem/";
            Problem problem = new Problem();
            problem.setContestId(contestId);
            problem.setId(problemId);
            problem.setDifficulty(addProblemFilesPayload.getDifficulty());
            Contest contest = contestRepository.findById(contestId).get();
            contest.addProblem(problemId);
            contestRepository.save(contest);
            problemRepository.save(problem);
            addProblemService = new AddProblemService();
            if(addProblemFilesPayload.getProblemStatement() != null)
                addProblemService.saveProblemStatement(addProblemFilesPayload.getProblemStatement(), path);
            if(addProblemFilesPayload.getInputFile() != null)
                addProblemService.saveInputFile(addProblemFilesPayload.getInputFile(), path);
            if(addProblemFilesPayload.getOutputFile() != null)
                addProblemService.saveOutputFile(addProblemFilesPayload.getOutputFile(), path);
            if(addProblemFilesPayload.getEditorialFile() != null)
                addProblemService.saveEditorialFile(addProblemFilesPayload.getEditorialFile(), path);
            
            return new ApiResponse(true, "Files Saved Successfully");
        } catch (Exception e) {
            // System.out.println(e.getMessage());
            return new ApiResponse(false, e.getMessage());
        }
    }
}

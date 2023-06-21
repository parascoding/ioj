package ioj.judge.controller.UserController;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import ioj.judge.dao.ProblemRepository;
import ioj.judge.entities.Problem;
import ioj.judge.payload.ApiResponse;
import ioj.judge.payload.UserPayloads.SeeEditorialPayload;
import ioj.judge.payload.UserPayloads.SeeProblemPayload;
import ioj.judge.service.FetchProblemStatement;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("compete/{contestId}/{problemId}/")
@CrossOrigin("*")
public class SeeProblemController {
    @Autowired
    private ProblemRepository problemRepository;
    
    private FetchProblemStatement fetchFileService;
    
    public SeeProblemController(){
        fetchFileService = new FetchProblemStatement();
    }
    @GetMapping("view")
    private ApiResponse viewProblem(@PathVariable String contestId,
                                    @PathVariable String problemId) throws Exception{
        try {
            Problem problem = problemRepository.findById(problemId).get();
            if(problem == null || !problem.getContestId().equals(contestId)){
                throw new Exception("Problem Not Found");
            }
            // File file = fetchFileService.fetchProblemStatement(contestId, problemId);
            StringBuilder markdown = new StringBuilder(fetchFileService.fetchProblemStatementString(contestId, problemId));
            /*
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder markdown = new StringBuilder();
            String s;
            while((s = br.readLine()) != null){
            	markdown.append(s);
            }
            */
            SeeProblemPayload seeProblemPayload = new SeeProblemPayload();
            // seeProblemPayload.setIsSuccess(true);
            // seeProblemPayload.setProblemStatement(file);
            seeProblemPayload.setMarkdown(markdown.toString());
            // seeProblemPayload.setMarkdown("HI AM HERE");
            // seeProblemPayload.setMessage("Added File");
            return seeProblemPayload;
        } catch (Exception e) {
            return new ApiResponse(false, e.getMessage());
        }
    }
    
}

package ioj.judge.controller.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ioj.judge.dao.ContestRepository;
import ioj.judge.entities.Contest;
import ioj.judge.payload.ApiResponse;
import ioj.judge.payload.UserPayloads.AllContestPayload;
import ioj.judge.payload.UserPayloads.SeeContestPayload;

@RestController
@RequestMapping("compete/")
@CrossOrigin("*")
public class SeeContestController {
    @Autowired
    private ContestRepository contestRepository;

    @GetMapping("/")
    private ApiResponse seeAllContest() throws Exception{
        try {
            
            List<Contest> list = contestRepository.findAll(Sort.by(Sort.Direction.DESC, "endTime"));
            AllContestPayload allContestPayload = new AllContestPayload(list);
            allContestPayload.setIsSuccess(true);
            allContestPayload.setMessage("List of Contests");
            return allContestPayload;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ApiResponse(false, e.getMessage());
        }
    }

    @GetMapping("/{contestId}/")
    private ApiResponse seeContest(@PathVariable String contestId) throws Exception{
        try {
            System.out.println("WAS HERE");
            Contest contest = contestRepository.findById(contestId).get();
            if(contest == null)
                throw new Exception("No contest exists");
            ApiResponse seeContestPayload = new SeeContestPayload(contest.getStartTime(),
                        contest.getEndTime(), contest.getListOfProblems());
            seeContestPayload.setIsSuccess(true);
            return seeContestPayload;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ApiResponse(false, e.getMessage());
        }
    }
}

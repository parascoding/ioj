package ioj.judge.controller.AdminController;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ioj.judge.dao.ContestRepository;
import ioj.judge.entities.Contest;
import ioj.judge.payload.ApiResponse;

@RestController
@RequestMapping("/admin")
public class AddContestController {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Autowired
    private ContestRepository contestRepository;
    
    @PostMapping("/createContest")
    public ApiResponse createContest(String contestId, String startTime, String endTime) throws Exception{
        try {
            Contest contest = new Contest();
            contest.setId(contestId);
            contest.setStartTime(sdf.parse(startTime));
            contest.setEndTime(sdf.parse(endTime));
            contestRepository.save(contest);
            System.out.println("Contest is added");
            return new ApiResponse(true, "Contest Created Successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ApiResponse(false, e.getMessage());
        }
    }
}

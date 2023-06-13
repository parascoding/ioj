package ioj.judge.controller.AdminController;

import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import ioj.judge.dao.ContestRepository;
import ioj.judge.entities.Contest;
import ioj.judge.payload.ApiResponse;
import ioj.judge.payload.AdminPayload.AddContestPayload;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AddContestController {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Autowired
    private ContestRepository contestRepository;
    
    @PostMapping("/createContest")
    public ApiResponse createContest(@RequestBody AddContestPayload addContestPayload) throws Exception{
        try {
            System.out.println("ADDING: " + addContestPayload.getContestId());
            Contest contest = new Contest();
            contest.setId(addContestPayload.getContestId());
            contest.setStartTime(sdf.parse(addContestPayload.getStartTime()));
            contest.setEndTime(sdf.parse(addContestPayload.getEndTime()));
            contestRepository.save(contest);
            System.out.println("Contest is added");
            return new ApiResponse(true, "Contest Created Successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ApiResponse(false, e.getMessage());
        }
    }
}

package ioj.judge.controller.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ioj.judge.dao.LeaderBoardRepository;
import ioj.judge.entities.Leaderboard;
import ioj.judge.payload.ApiResponse;
import ioj.judge.payload.SeeLeaderBoardPayload;

@RestController
@CrossOrigin("*")
@RequestMapping("/compete/{contestId}")
public class SeeLeaderboard {
    @Autowired
    private LeaderBoardRepository leaderBoardRepository;


    @GetMapping("/leaderBoard")
    private ApiResponse seeLeaderBoard(@PathVariable String contestId) throws Exception{
        try {
            SeeLeaderBoardPayload seeLeaderBoardPayload = new SeeLeaderBoardPayload();
            Leaderboard leaderboard = leaderBoardRepository.findById(contestId).get();
            seeLeaderBoardPayload.setIsSuccess(true);
            seeLeaderBoardPayload.setLeaderBoard(leaderboard.getUserIdToScoreMap());
            seeLeaderBoardPayload.setMessage("Leaderboard Fetched");
            return seeLeaderBoardPayload;
        } catch (Exception e) {
            return new ApiResponse(false, e.getMessage());
        }
    }
}

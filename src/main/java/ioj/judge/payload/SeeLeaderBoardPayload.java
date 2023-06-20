package ioj.judge.payload;

import java.util.TreeMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeeLeaderBoardPayload extends ApiResponse{
    private TreeMap<String, Integer> leaderBoard;
}

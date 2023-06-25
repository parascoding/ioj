package ioj.judge.payload;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
    private Map<String, Integer> leaderBoard;
    public void setLeaderBoard(Map<String, Integer> hm){
        leaderBoard = new HashMap<>();
        // System.out.println(hm);
        List<Node> list = new ArrayList<>();
        for(Map.Entry<String, Integer> e : hm.entrySet()){
            list.add(new Node(e.getKey(), e.getValue()));
        }
        Collections.sort(list,
            new Comparator<Node>(){
                public int compare(Node n1, Node n2){
                    return n2.score - n1.score;
                }
            }
        );

        leaderBoard = new LinkedHashMap<>();
        for(int i = 0; i < list.size(); i++)
            leaderBoard.put(list.get(i).name, list.get(i).score);
        
    }
    static class Node{
        String name;
        int score;
        Node(String name, int score){
            this.name = name;
            this.score = score;
        }
    }
}

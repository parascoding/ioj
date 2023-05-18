package ioj.judge.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document("Problem")
@Getter
@Setter
public class Problem {
    private String id;
    private String contestId;
}

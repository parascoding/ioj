package ioj.judge.entities;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Submission {
    @Id
    private long id;
    private String userId;
    private String result;
    private String contestId;
    private String problemId;
    private String sourceCode;
    private String language;
}

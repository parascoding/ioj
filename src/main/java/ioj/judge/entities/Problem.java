package ioj.judge.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.Setter;

@Document("Problem")
@Getter
@Setter
public class Problem {
	@Id
    private String id;
    private String contestId;
}

package ioj.judge.payload;

import java.io.File;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionPayload {
    private String contestId;
    private String problemId;
    private String userId;
    private String code;
    private String language;
    private String filePath;
    private File sourceCode;
    private String basePath;
}

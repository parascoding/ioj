package ioj.judge.payload;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotNull;
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
    // private String code;
    @NotNull(message = "User Must select a Language")
    private String language;
    private String filePath;
    private MultipartFile sourceCode;
    // private byte[] sourceCode;
    private String basePath;
    private long timeStamp;
}

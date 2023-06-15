package ioj.judge.payload.UserPayloads;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import ioj.judge.payload.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.springframework.core.io.Resource;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SeeProblemPayload{
    // private File problemStatement;
    private File problemStatement;
    private String markdown;
}

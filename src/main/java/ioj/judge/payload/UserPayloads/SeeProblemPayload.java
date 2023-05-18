package ioj.judge.payload.UserPayloads;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import ioj.judge.payload.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class SeeProblemPayload extends ApiResponse{
    private File problemStatement;
}

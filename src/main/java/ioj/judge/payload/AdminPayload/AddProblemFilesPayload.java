package ioj.judge.payload.AdminPayload;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddProblemFilesPayload {
    @NotNull(message = "File Can't be empty")
    private MultipartFile problemStatement;
    @NotNull(message = "File Can't be empty")
    private MultipartFile inputFile;
    @NotNull(message = "File Can't be empty")
    private MultipartFile outputFile;
    private String difficulty = "Easy";
    private MultipartFile editorialFile;
}

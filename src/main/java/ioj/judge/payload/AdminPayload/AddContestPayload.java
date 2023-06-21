package ioj.judge.payload.AdminPayload;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class AddContestPayload {
	@Size(min = 3, max = 10, message = "Contest Id length must be between 3 and 10")
	private String contestId;
	private long startTime;
	private long endTime;
}

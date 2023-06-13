package ioj.judge.payload.AdminPayload;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddContestPayload {
	private String contestId;
	private String startTime;
	private String endTime;
}

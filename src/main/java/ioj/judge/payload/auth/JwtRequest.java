package ioj.judge.payload.auth;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class JwtRequest {

	@NotEmpty(message = "Id can't be empty")
    private String id;

	@NotEmpty(message = "Password can't be empty")
    private String password;

}
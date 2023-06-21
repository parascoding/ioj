package ioj.judge.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ioj.judge.payload.ApiResponse;;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeeProfilePayload extends ApiResponse{
    private String name;
    private String password;
}

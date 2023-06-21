package ioj.judge.payload.UserPayloads;

import ioj.judge.payload.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeeEditorialPayload extends ApiResponse{
    private String markDown;
}

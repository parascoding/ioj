package ioj.judge.payload.auth;


import ioj.judge.payload.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse extends ApiResponse{
    private String jwtToken;
    private String id;
    private String name;
    private String role;
}


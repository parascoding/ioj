package ioj.judge.payload.auth;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterRequest {

    @Size(min = 4, message = "Name must be min of 3 characters !!")
    private String name;
    
    @NotEmpty(message = "Id must not be empty")
    @Size(min = 3, max = 20, message = "Id must be min of 3 chars and max of 20 chars !!")
    
    private String id;
    
    @NotEmpty(message = "Password must not be empty")
	@Size(min = 3, max = 20, message = "Password must be min of 3 chars and max of 20 chars !!")
    private String password;

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


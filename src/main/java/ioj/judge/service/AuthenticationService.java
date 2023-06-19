package ioj.judge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ioj.judge.entities.Role;
import ioj.judge.entities.User;
import ioj.judge.payload.AuthenticationResponse;
import ioj.judge.payload.ApiResponse;
import ioj.judge.payload.AuthenticationRequest;
import ioj.judge.payload.RegisterRequest;
import ioj.judge.exceptions.ApiException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @Autowired
    private final ioj.judge.dao.UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    public AuthenticationResponse register(RegisterRequest request) throws Exception{
        try {
            System.out.println(request);
            
            boolean bool = repository.existsById(request.getId());
            if(bool)
                throw new Exception("User Already Exists");
            User user = new User();
            user.setUserId(request.getId());
            user.setName(request.getName());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setRole(Role.USER);
            repository.save(user);
            System.out.println("REGITSTERD: "+user);
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
            .token(jwtToken)
            .name(request.getName())
            .role(Role.USER.toString())
            .build();
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("SOME ERROR OCCURED: "+e.getMessage());
            return new AuthenticationResponse();
        } 

    }

    
    public AuthenticationResponse authenticate(AuthenticationRequest request) throws Exception{
        System.out.println("CAME 56");
    	try{
    		authenticationManager.authenticate(
    	        new UsernamePasswordAuthenticationToken(request.getId(), request.getPassword())
	        );
        } catch (BadCredentialsException e) {
			System.out.println("Invalid Detials !!");
			throw new ApiException("Invalid username or password !!");
		}
        var user = repository.findById(request.getId()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
        .token(jwtToken)
        .id(user.getUserId())
        .name(user.getName())
        .role(user.getRole().toString())
        .build();
        
    }
    
}

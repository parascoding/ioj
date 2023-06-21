package ioj.judge.controller.TempController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ioj.judge.dao.UserRepository;
import ioj.judge.entities.Role;
import ioj.judge.entities.User;
import ioj.judge.payload.ApiResponse;
import ioj.judge.payload.auth.JwtRequest;
import ioj.judge.payload.auth.JwtResponse;
import ioj.judge.payload.auth.RegisterRequest;
import ioj.judge.security.JwtHelper;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/signup")
    public ApiResponse signup(@RequestBody RegisterRequest registerRequest) throws Exception{
        try {
            boolean bool = createUser(registerRequest);
            return new ApiResponse(bool, (bool ? "User Created" : "User Already Existed"));
        } catch (Exception e) {
            return new ApiResponse(false, e.getMessage());
        }
    }

    public boolean createUser(RegisterRequest registerRequest) throws Exception{
        try {
            if(userRepository.existsById(registerRequest.getId()))
                throw new Exception("User already exist");
            User user = new User();
            user.setName(registerRequest.getName());
            user.setUserId(registerRequest.getId());
            user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            user.setRole(Role.USER);
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @PostMapping("/login")
    public ApiResponse login(@RequestBody JwtRequest request) throws Exception{
        try {
            System.out.println(request);
            this.doAuthenticate(request.getId(), request.getPassword());
    
            String role = userRepository.findById(request.getId()).get().getRole().toString();
            UserDetails userDetails = userDetailsService.loadUserByUsername(request.getId());
            System.out.println(userDetails.getAuthorities());
            String token = this.helper.generateToken(userDetails, role);
    
            JwtResponse response = JwtResponse.builder()
                    .jwtToken(token)
                    .id(userDetails.getUsername())
                    .role(role)
                    .build();
            response.setIsSuccess(true);
            response.setMessage("Login Successfull");
            return response;
        } catch (Exception e) {
            return new ApiResponse(false, e.getMessage());
        }
    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }
    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
package ioj.judge.controller.HomeController;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ioj.judge.payload.AuthenticationRequest;
import ioj.judge.payload.AuthenticationResponse;
import ioj.judge.payload.RegisterRequest;
import ioj.judge.service.AuthenticationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
        @Valid @RequestBody RegisterRequest request
    ) throws Exception{
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticiate")
    public ResponseEntity<AuthenticationResponse> authenticate(
 	@Valid @RequestBody AuthenticationRequest request
    ) throws Exception{
        System.out.println("CAME 39");
        return ResponseEntity.ok(service.authenticate(request));
    }

}
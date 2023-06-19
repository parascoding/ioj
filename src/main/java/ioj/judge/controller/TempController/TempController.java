package ioj.judge.controller.TempController;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ioj.judge.entities.User;

@RestController
public class TempController {

    @GetMapping("/admin/hello")
    public String adminHello(){
        return "Admin Hello";
    }
    @GetMapping("/user/hello")
    public String userHello(){
        return "User Hello";
    }
    @GetMapping("/auth/publicHello")
    public String publicHello(){
        return "Public Hello";
    }
    @GetMapping("/currentUser")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }
}

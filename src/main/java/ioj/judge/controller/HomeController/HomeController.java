package ioj.judge.controller.HomeController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@CrossOrigin(origins = "*")
@RestController
public class HomeController {
    @GetMapping("h")
    public String home(){
        return "HELLOW";
    }
}

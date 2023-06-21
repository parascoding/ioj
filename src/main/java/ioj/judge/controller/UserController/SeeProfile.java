package ioj.judge.controller.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ioj.judge.dao.UserRepository;
import ioj.judge.entities.User;
import ioj.judge.payload.ApiResponse;
import ioj.judge.payload.SeeProfilePayload;

@RestController
@RequestMapping("{userId}/")
@CrossOrigin("*")
public class SeeProfile {
    
    @Autowired
    private UserRepository  userRepository;
    @GetMapping
    public ApiResponse seeProfile(@PathVariable String userName) throws Exception{
        try {
            User user = userRepository.findById(userName).get();
            SeeProfilePayload  seeProfilePayload = new SeeProfilePayload();
            seeProfilePayload.setIsSuccess(true);
            seeProfilePayload.setMessage("Fetched");
            seeProfilePayload.setName(user.getName());
            seeProfilePayload.setPassword(user.getPassword());
            return seeProfilePayload;
        } catch (Exception e) {
            return new ApiResponse(false, e.getMessage());
        }
    }
}

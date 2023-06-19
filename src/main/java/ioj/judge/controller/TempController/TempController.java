// package ioj.judge.controller.TempController;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import ioj.judge.entities.User;
// import ioj.judge.service.UserService;

// @RestController
// @RequestMapping("/home")
// public class TempController {
//     @Autowired
//     private UserService userService;

//     @GetMapping("/users")
//     public List<User> getUsers(){
//         System.out.println("Getting users");
//         return this.userService.getUsers();
//     }
// }

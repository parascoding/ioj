package ioj.judge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ioj.judge.dao.UserRepository;
import ioj.judge.entities.Role;
import ioj.judge.entities.User;
import ioj.judge.payload.auth.RegisterRequest;
import net.bytebuddy.asm.Advice.Return;

@Service
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    // @Override
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     User user = userRepository.findById(username). orElseThrow(() -> new RuntimeException("User Not Found"));
    //     return user;
    // }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username). orElseThrow(() -> new RuntimeException("User Not Found"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }
    // public Role getRole(String username){
    //     return loadUserByUsername(username).getAuthorities();
    // }
}

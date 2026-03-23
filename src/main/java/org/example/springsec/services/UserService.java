package org.example.springsec.services;
import org.example.springsec.entities.Users;
import org.example.springsec.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    public Users registerUser(Users user){
        return userRepo.save(user);
    }
    public String verify(Users user){
        Authentication authentication = authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user);
        }
        else{
            return "no Such User";
        }
    }

}

package com.techelevator.business;
import com.techelevator.util.BasicLogger;
import com.techelevator.model.User;
import com.techelevator.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    User findByUserId(Long userId){
        return userRepository.findByUserId(userId);
    }

    List<User> findAll(){
        return userRepository.findAll();
    }

    public User create(String username, String password ) {
        boolean userCreated = false;
        User newUser = new User();
        String password_hash = new BCryptPasswordEncoder().encode(password);
        newUser.setUsername(username);
        newUser.setPassword(password_hash);
        //newUser.setAuthorities("USER");
        try {
            userRepository.saveAndFlush(newUser);
            userCreated = true;
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
            userCreated = false;
        }

        return newUser;
    }



    public User findByUsername(String username) throws UsernameNotFoundException {
        try {
            return userRepository.findByUsername(username);
        } catch (Exception e) {
            throw new UsernameNotFoundException("User '" + username + "' was not found.");
        }
    }

}


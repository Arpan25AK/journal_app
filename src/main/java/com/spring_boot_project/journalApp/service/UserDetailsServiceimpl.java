package com.spring_boot_project.journalApp.service;

import com.spring_boot_project.journalApp.entity.User;
import com.spring_boot_project.journalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceimpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User cachedUser = (User)redisTemplate.opsForValue().get("user:" + username);

        if (cachedUser != null) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username(cachedUser.getUserName())
                    .password(cachedUser.getPassword())
                    .roles(cachedUser.getRoles().toArray(new String[0]))
                    .build();
        }

        User user = userRepository.findByuserName(username);

        if(user != null){
            UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUserName())
                    .password(user.getPassword())
                    .roles(user.getRoles().toArray(new String[0]))
                    .build();
            return userDetails;
        }
            throw new UsernameNotFoundException("User not found with username: " + username);

    }
}

package com.link.rider.service;

import com.link.rider.model.UserDao;
import com.link.rider.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DatabaseUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDao> userDaoOptional = userRepository.findByUsername(username);

        if (userDaoOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        }

        UserDao userDao = userDaoOptional.get();

        return User.withUsername(userDao.getUsername())
                .password(userDao.getPassword())
                .roles("USER")
                .build();
    }
}

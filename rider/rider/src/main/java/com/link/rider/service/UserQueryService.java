package com.link.rider.service;

import com.link.rider.command.UserDaoToUserResponse;
import com.link.rider.dto.UserResponse;
import com.link.rider.model.UserDao;
import com.link.rider.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserQueryService {
    private final UserRepository userRepository;
    private final UserDaoToUserResponse entityToDto;

    @Transactional
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
                .map(entityToDto::convert)
                .toList();
    }

    @Transactional
    public UserResponse findByUsername(String username) {
        Optional<UserDao> userDao = userRepository.findByUsername(username);

        return userDao.map(entityToDto::convert).orElse(null);

    }
}

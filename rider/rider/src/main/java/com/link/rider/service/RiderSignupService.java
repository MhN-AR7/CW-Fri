package com.link.rider.service;

import com.link.rider.command.RiderSignupRequestToRider;
import com.link.rider.dto.RiderSignupRequest;
import com.link.rider.exception.UsernameAlreadyExistsException;
import com.link.rider.model.Rider;
import com.link.rider.repository.RiderRepository;
import com.link.rider.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RiderSignupService {
    private final UserRepository userRepository;
    private final RiderRepository riderRepository;
    private final PasswordEncoder passwordEncoder;
    private final RiderSignupRequestToRider dtoToEntity;

    @Transactional
    public void signup(RiderSignupRequest riderSignupRequest) {
        if (userRepository.existsByUsername(riderSignupRequest.username())) {
            throw new UsernameAlreadyExistsException(riderSignupRequest.username());
        }

        Rider rider = dtoToEntity.convert(riderSignupRequest);
        rider.setPassword(passwordEncoder.encode(riderSignupRequest.password()));

        riderRepository.save(rider);
    }
}

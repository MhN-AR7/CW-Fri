package com.link.rider.service;

import com.link.rider.command.DriverSignupRequestToDriver;
import com.link.rider.dto.DriverSignupRequest;
import com.link.rider.exception.UsernameAlreadyExistsException;
import com.link.rider.model.Driver;
import com.link.rider.repository.DriverRepository;
import com.link.rider.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverSignupService {
    private final UserRepository userRepository;
    private final DriverRepository driverRepository;
    private final PasswordEncoder passwordEncoder;
    private final DriverSignupRequestToDriver dtoToEntity;

    public void signup(DriverSignupRequest driverSignupRequest) {
        if (userRepository.existsByUsername(driverSignupRequest.username())) {
            throw new UsernameAlreadyExistsException(driverSignupRequest.username());
        }

        Driver driver = dtoToEntity.convert(driverSignupRequest);
        driver.setPassword(passwordEncoder.encode(driverSignupRequest.password()));

        driverRepository.save(driver);
    }
}

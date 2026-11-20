package com.link.rider.controller;

import com.link.rider.dto.DriverSignupRequest;
import com.link.rider.service.DriverSignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class DriverSignupController {
    private final DriverSignupService driverSignupService;

    @PostMapping("/signup/driver")
    public ResponseEntity<Map<String, String>> signup(
            @Valid @RequestBody DriverSignupRequest driverSignupRequest,
            BindingResult validation
    ) {
        if (validation.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    Map.of("message", "Check your signup detail.")
            );
        }

        driverSignupService.signup(driverSignupRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "Rider created successfully."));
    }
}

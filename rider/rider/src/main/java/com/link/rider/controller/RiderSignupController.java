package com.link.rider.controller;

import com.link.rider.dto.RiderSignupRequest;
import com.link.rider.exception.UsernameAlreadyExistsException;
import com.link.rider.service.RiderSignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class RiderSignupController {
    private final RiderSignupService riderSignupService;

    @PostMapping("/signup/rider")
    public ResponseEntity<Map<String, String>> signup(
            @Valid @RequestBody RiderSignupRequest riderSignupRequest,
            BindingResult validation
    ) {
        if (validation.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    Map.of("message", "Check your signup detail.")
            );
        }

        riderSignupService.signup(riderSignupRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "Rider created successfully."));
    }
}

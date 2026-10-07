package com.vansh.gatekeeper.management.controller;

import com.vansh.gatekeeper.management.dto.responseDto.HealthResponseDto;
import com.vansh.gatekeeper.management.service.HealthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/health")
public class HealthController {

    public final HealthService healthService;

    private String serviceName;
    private String serviceDescription;


    public HealthController(
           @Value("${info.app.name}") String serviceName,
           @Value("${info.app.description}") String serviceDescription,
           HealthService healthService) {
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.healthService = healthService;
    }

    @GetMapping
    public ResponseEntity<HealthResponseDto> health() {

        String dbStatus = healthService.getHealth();

    return ResponseEntity.ok(new HealthResponseDto(
            "Up",dbStatus, LocalDateTime.now()));
    }


}

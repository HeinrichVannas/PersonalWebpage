package com.example.backend.health;

import com.example.backend.emailservice.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@CrossOrigin("*")
@RestController
public class HealthController {
    private static Logger log = LogManager.getLogger(HealthController.class);
    @GetMapping("/")
    public ResponseEntity<String> healthCheck() {
        log.info("Health Check was called");
        return ResponseEntity.ok("Service is running");
    }
}
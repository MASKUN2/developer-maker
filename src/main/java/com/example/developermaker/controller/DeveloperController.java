package com.example.developermaker.controller;

import com.example.developermaker.dto.request.DeveloperCreateRequest;
import com.example.developermaker.service.DeveloperService;
import com.example.developermaker.service.DeveloperServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/developers")
@RequiredArgsConstructor
public class DeveloperController {
    private final DeveloperService developerService;
    @GetMapping
    public ResponseEntity<Object> getDeveloper() {
        return ResponseEntity.ok(developerService.getDeveloperAll());
    }

    @PostMapping
    public ResponseEntity<Object> postDeveloper(
            @RequestBody DeveloperCreateRequest request) {
        log.info("request = {}", request);
        developerService.createDeveloper(request);
        return new ResponseEntity<>("create ok", HttpStatus.CREATED);
    }
}

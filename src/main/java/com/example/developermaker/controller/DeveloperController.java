package com.example.developermaker.controller;

import com.example.developermaker.dto.DeveloperDto;
import com.example.developermaker.dto.request.DeveloperCreateRequest;
import com.example.developermaker.exception.NoSuchDataException;
import com.example.developermaker.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/developers")
@RequiredArgsConstructor
public class DeveloperController {
    private final DeveloperService developerService;
    @GetMapping
    public ResponseEntity<Object> getDeveloperAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "name")String name) {
        Page<DeveloperDto> developerDtoPage = developerService.getDeveloperAll(page, size, name);
        return ResponseEntity.status(HttpStatus.OK).body(developerDtoPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDeveloperOne(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(developerService.getDeveloperOne(id));
    }

    @PostMapping
    public ResponseEntity<Object> postDeveloper(
            @RequestBody DeveloperCreateRequest request) {
        log.info("request = {}", request);
        developerService.createDeveloper(request);
        return new ResponseEntity<>("create ok", HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> patchDeveloper(
            @PathVariable Long id,
            @RequestBody Map<String, Object> request) {
        log.info("request = {}", request);
        developerService.patialUpdate(id, request);
        return new ResponseEntity<>("update ok", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeDeveloperOne(@PathVariable Long id){
        developerService.removeDeveloperOne(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(NoSuchDataException.class)
    public ResponseEntity<Object> HandleNoSuchDataException(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> HandleOtherException(){
        return ResponseEntity.badRequest().build();
    }
}

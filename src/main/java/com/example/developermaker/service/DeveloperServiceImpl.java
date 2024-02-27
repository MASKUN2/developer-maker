package com.example.developermaker.service;

import com.example.developermaker.dto.DeveloperDto;
import com.example.developermaker.dto.request.DeveloperCreateRequest;
import com.example.developermaker.entity.Developer;
import com.example.developermaker.repository.DeveloperRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DeveloperServiceImpl implements DeveloperService{
    private final DeveloperRepository developerRepository;
    @Override
    @Transactional
    public void createDeveloper(DeveloperCreateRequest request) {
        Developer developer = request.toEntity();
        log.info("developer = {}", developer);
        developerRepository.save(developer);
        log.info("developerPersisted = {}", developer);
    }

    @Override
    public List<DeveloperDto> getDeveloperAll() {
        var developerDtoList = developerRepository.findAll().stream()
                .map(DeveloperDto::from)
                .toList();
        log.info("developerDtoList = {}", developerDtoList);
        return developerDtoList;
    }
}

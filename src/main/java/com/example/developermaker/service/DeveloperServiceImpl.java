package com.example.developermaker.service;

import com.example.developermaker.dto.DeveloperDto;
import com.example.developermaker.dto.request.DeveloperCreateRequest;
import com.example.developermaker.entity.Developer;
import com.example.developermaker.exception.NoSuchDataException;
import com.example.developermaker.repository.DeveloperRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @Override
    public DeveloperDto getDeveloperOne(Long id) {
        Optional<Developer> developerOpt = developerRepository.findById(id);
        return DeveloperDto.from(developerOpt.orElseThrow(NoSuchDataException::new));
    }

    @Override
    public void removeDeveloperOne(Long id) {
        Optional<Developer> developerOpt = developerRepository.findById(id);
        developerRepository.delete(developerOpt.orElseThrow(NoSuchDataException::new));
    }

    @Override
    @Transactional
    public void patialUpdate(Long id, Map<String, Object> request) {
        Developer developer = developerRepository.findById(id).orElseThrow(NoSuchDataException::new);
        developer.partialUpdate(request);
        log.info("developer = {}", developer);
    }
}

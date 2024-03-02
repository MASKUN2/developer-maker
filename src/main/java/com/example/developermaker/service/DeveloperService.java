package com.example.developermaker.service;

import com.example.developermaker.dto.DeveloperDto;
import com.example.developermaker.dto.request.DeveloperCreateRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface DeveloperService {
    void createDeveloper(DeveloperCreateRequest request);

    Page<DeveloperDto> getDeveloperAll(int page, int size, String name);

    DeveloperDto getDeveloperOne(Long id);

    void removeDeveloperOne(Long id);

    void patialUpdate(Long id, Map<String, Object> request);
}

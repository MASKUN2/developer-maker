package com.example.developermaker.service;

import com.example.developermaker.dto.DeveloperDto;
import com.example.developermaker.dto.request.DeveloperCreateRequest;

import java.util.List;

public interface DeveloperService {
    void createDeveloper(DeveloperCreateRequest request);

    List<DeveloperDto> getDeveloperAll();
}

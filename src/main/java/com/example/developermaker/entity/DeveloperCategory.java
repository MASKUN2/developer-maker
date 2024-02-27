package com.example.developermaker.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public enum DeveloperCategory {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드"),
    DEVOPS("데브옵스");

    private final String description;
}

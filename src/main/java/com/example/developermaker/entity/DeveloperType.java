package com.example.developermaker.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public enum DeveloperType {
    NEWCOMER("신입"),
    JUNIOR("주니어"),
    SENIOR("시니어");

    private final String description;

}

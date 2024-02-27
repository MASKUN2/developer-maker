package com.example.developermaker.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
@ToString
@Getter
@NoArgsConstructor
public abstract class BaseDto {
    protected LocalDateTime createdAt;
    protected LocalDateTime modifiedAt;

    protected BaseDto(LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}

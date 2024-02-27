package com.example.developermaker.dto;

import com.example.developermaker.entity.Developer;
import com.example.developermaker.entity.DeveloperCategory;
import com.example.developermaker.entity.DeveloperType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString(callSuper = true)
@Getter
public class DeveloperDto extends BaseDto{
    private Long id;
    private String name;
    private DeveloperCategory category;
    private DeveloperType type;
    private Integer experienceYear;

    @Builder
    public DeveloperDto(LocalDateTime createdAt, LocalDateTime modifiedAt, Long id, String name, DeveloperCategory category, DeveloperType type, Integer experienceYear) {
        super(createdAt, modifiedAt);
        this.id = id;
        this.name = name;
        this.category = category;
        this.type = type;
        this.experienceYear = experienceYear;
    }

    public static DeveloperDto from(Developer entity){
        return DeveloperDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .type(entity.getType())
                .category(entity.getCategory())
                .experienceYear(entity.getExperienceYear())
                .createdAt(entity.getCreatedAt())
                .modifiedAt(entity.getModifiedAt())
                .build();
    }
}

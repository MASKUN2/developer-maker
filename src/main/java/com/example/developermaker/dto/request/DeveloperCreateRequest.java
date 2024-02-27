package com.example.developermaker.dto.request;

import com.example.developermaker.entity.Developer;
import com.example.developermaker.entity.DeveloperCategory;
import com.example.developermaker.entity.DeveloperType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeveloperCreateRequest {
    private String name;

    private DeveloperCategory category;

    private DeveloperType type;

    private Integer experienceYear;

    public Developer toEntity(){
        return Developer.builder()
                .name(name)
                .type(type)
                .category(category)
                .experienceYear(experienceYear)
                .build();
    }
}

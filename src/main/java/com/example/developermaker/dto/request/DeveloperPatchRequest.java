package com.example.developermaker.dto.request;

import com.example.developermaker.entity.Developer;
import com.example.developermaker.entity.DeveloperCategory;
import com.example.developermaker.entity.DeveloperType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeveloperPatchRequest {
    private String name;

    private DeveloperCategory category;

    private DeveloperType type;

    private Integer experienceYear;
}

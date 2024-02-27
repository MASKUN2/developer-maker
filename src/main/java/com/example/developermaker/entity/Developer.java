package com.example.developermaker.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity @Table(name = "developer")
public class Developer extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name="category")
    @Enumerated(EnumType.STRING)
    private DeveloperCategory category;

    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private DeveloperType type;

    @Column(name = "experience_year")
    private Integer experienceYear;

    @Builder
    public Developer(String name, DeveloperCategory category, DeveloperType type, Integer experienceYear) {
        this.name = name;
        this.category = category;
        this.type = type;
        this.experienceYear = experienceYear;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", type=" + type +
                ", experienceYear=" + experienceYear +
                "} " + super.toString();
    }
}

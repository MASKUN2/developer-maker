package com.example.developermaker.repository;

import com.example.developermaker.entity.Developer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DeveloperRepositoryCustom {
    public Page<Developer> findList(Pageable pageable, String name);
}

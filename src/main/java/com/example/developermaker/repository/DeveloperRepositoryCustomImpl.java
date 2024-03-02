package com.example.developermaker.repository;

import com.example.developermaker.entity.Developer;
import com.example.developermaker.entity.QDeveloper;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
public class DeveloperRepositoryCustomImpl implements DeveloperRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public Page<Developer> findList(Pageable pageable, String name) {

        QDeveloper developer = QDeveloper.developer;

        List<Developer> list = jpaQueryFactory
                .selectFrom(developer)
                .where(developer.name.contains(name))
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(developer.id.desc())
                .fetch();

        Long totalCount = jpaQueryFactory
                .select(developer.count())
                .from(developer)
                .fetchOne();

        return new PageImpl<>(list, pageable, totalCount);

    }
}


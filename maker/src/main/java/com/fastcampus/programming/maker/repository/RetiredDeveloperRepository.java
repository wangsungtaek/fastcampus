package com.fastcampus.programming.maker.repository;

import com.fastcampus.programming.maker.entity.Developer;
import com.fastcampus.programming.maker.entity.RetiredDeveloper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RetiredDeveloperRepository
        extends JpaRepository<RetiredDeveloper, Long> {
}

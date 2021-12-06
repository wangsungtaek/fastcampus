package com.fastcampus.programming.maker.repository;

import com.fastcampus.programming.maker.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    Optional<Object> findByMemberId(String memberId);
}

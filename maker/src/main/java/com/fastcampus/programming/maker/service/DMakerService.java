package com.fastcampus.programming.maker.service;

import com.fastcampus.programming.maker.entity.Developer;
import com.fastcampus.programming.maker.repository.DeveloperRepository;
import com.fastcampus.programming.maker.type.DeveloperLevel;
import com.fastcampus.programming.maker.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DMakerService {
    private final DeveloperRepository developerRepository;

    @Transactional
    public void createDeveloper() {
        Developer developer = Developer.builder()
                .developerLevel(DeveloperLevel.JUNIOR)
                .developerSkillType(DeveloperSkillType.FRONT_END)
                .experienceYears(2)
                .name("Olaf")
                .age(5)
                .build();

        developerRepository.save(developer);
    }
}

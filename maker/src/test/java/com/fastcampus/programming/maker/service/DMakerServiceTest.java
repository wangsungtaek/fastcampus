package com.fastcampus.programming.maker.service;

import com.fastcampus.programming.maker.dto.CreateDeveloper;
import com.fastcampus.programming.maker.dto.DeveloperDto;
import com.fastcampus.programming.maker.type.DeveloperLevel;
import com.fastcampus.programming.maker.type.DeveloperSkillType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DMakerServiceTest {

    @Autowired
    private DMakerService dMakerService;

    @Test
    public void testSomething() {
        dMakerService.createDeveloper(CreateDeveloper.Request.builder()
                .developerLevel(DeveloperLevel.SENIOR)
                .developerSkillType(DeveloperSkillType.FRONT_END)
                .experienceYears(12)
                .memberId("memberId")
                .name("name")
                .age(32)
                .build());
        List<DeveloperDto> allEmployedDevelopers = dMakerService.getAllEmployedDevelopers();
        System.out.println("================");
        System.out.println(allEmployedDevelopers);
        System.out.println("================");
    }

}
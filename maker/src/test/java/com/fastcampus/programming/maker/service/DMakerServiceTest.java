package com.fastcampus.programming.maker.service;

import com.fastcampus.programming.maker.code.StatusCode;
import com.fastcampus.programming.maker.dto.CreateDeveloper;
import com.fastcampus.programming.maker.dto.DeveloperDetailDto;
import com.fastcampus.programming.maker.dto.DeveloperDto;
import com.fastcampus.programming.maker.entity.Developer;
import com.fastcampus.programming.maker.exception.DMakerErrorCode;
import com.fastcampus.programming.maker.exception.DMakerException;
import com.fastcampus.programming.maker.repository.DeveloperRepository;
import com.fastcampus.programming.maker.repository.RetiredDeveloperRepository;
import com.fastcampus.programming.maker.type.DeveloperLevel;
import com.fastcampus.programming.maker.type.DeveloperSkillType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DMakerServiceTest {

    @Mock
    private DeveloperRepository developerRepository;

    @Mock
    private RetiredDeveloperRepository retiredDeveloperRepository;

    @InjectMocks
    private DMakerService dMakerService;

    private final Developer defaultDeveloper = Developer.builder()
            .developerLevel(DeveloperLevel.SENIOR)
            .developerSkillType(DeveloperSkillType.FRONT_END)
            .experienceYears(12)
            .statusCode(StatusCode.EMPLOYED)
            .name("name")
            .age(12)
            .build();

    private final CreateDeveloper.Request defaultCreateRequest =
            CreateDeveloper.Request.builder()
                    .developerLevel(DeveloperLevel.SENIOR)
                    .developerSkillType(DeveloperSkillType.FRONT_END)
                    .experienceYears(12)
                    .memberId("memberId")
                    .name("name")
                    .age(32)
                    .build();

    @Test
    public void testSomething() {
        given(developerRepository.findByMemberId(anyString()))
                .willReturn(Optional.of(defaultDeveloper));

        DeveloperDetailDto developerDetailDto = dMakerService.getDeveloperDetail("memberId");

        assertEquals(DeveloperLevel.SENIOR, developerDetailDto.getDeveloperLevel());
        assertEquals(DeveloperSkillType.FRONT_END, developerDetailDto.getDeveloperSkillType());
        assertEquals(12, developerDetailDto.getExperienceYears());
    }

    @Test
    void createDeveloperTest_success() {
        //given
        given(developerRepository.findByMemberId(anyString()))
                .willReturn(Optional.empty());
        ArgumentCaptor<Developer> captor =
                ArgumentCaptor.forClass(Developer.class);

        //when
        CreateDeveloper.Response developer = dMakerService.createDeveloper(defaultCreateRequest);

        //then
        verify(developerRepository, times(1))
                .save(captor.capture());
        // 캡쳐된 데이터 확인
        Developer saveDeveloper = captor.getValue();
        assertEquals(DeveloperLevel.SENIOR, saveDeveloper.getDeveloperLevel());
        assertEquals(DeveloperSkillType.FRONT_END, saveDeveloper.getDeveloperSkillType());
        assertEquals(12, saveDeveloper.getExperienceYears());
    }

    @Test
    void createDeveloperTest_faild_with_duplicated() {
        //given
        given(developerRepository.findByMemberId(anyString()))
                .willReturn(Optional.empty());
        ArgumentCaptor<Developer> captor =
                ArgumentCaptor.forClass(Developer.class);

        //when
        //then
        DMakerException dMakerException = assertThrows(DMakerException.class,
                () -> dMakerService.createDeveloper(defaultCreateRequest)
        );

        assertEquals(DMakerErrorCode.DUPLICATED_MEMBER_ID, dMakerException.getDMakerErrorCode());
    }
}
package com.fastcampus.programming.maker.controller;

import com.fastcampus.programming.maker.dto.*;
import com.fastcampus.programming.maker.exception.DMakerException;
import com.fastcampus.programming.maker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DMaKerController {
    private final DMakerService dMakerService;

    @GetMapping("/developers")
    public List<DeveloperDto> getAllDevelopers() {
        log.info("GET /developers HTTP/1.1");

        return dMakerService.getAllEmployedDevelopers();

    }

    @GetMapping("/developers/{memberId}")
    public DeveloperDetailDto getDeveloperDetail(
        @PathVariable final String memberId
    ) {
        log.info("GET /developers HTTP/1.1");

        return dMakerService.getDeveloperDetail(memberId);
    }

    @PostMapping("/create-developer")
    public CreateDeveloper.Response createDeveloper(
            @Valid @RequestBody CreateDeveloper.Request request
    ) {

        log.info("request : {}", request);

        return dMakerService.createDeveloper(request);
    }

    @PutMapping("/developer/{memberId}")
    public DeveloperDetailDto editDeveloper(
            @PathVariable final String memberId,
            @Valid @RequestBody EditDeveloper.Request request
    ) {
        log.info("PUT /developers HTTP/1.1");

        return dMakerService.editDeveloper(memberId, request);
    }

    @DeleteMapping("/developer/{memberId}")
    public DeveloperDetailDto deleteDeveloper(
            @PathVariable final String memberId
    ) {

        return dMakerService.deleteDeveloper(memberId);
    }
}

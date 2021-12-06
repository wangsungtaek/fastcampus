package com.fastcampus.programming.maker.controller;

import com.fastcampus.programming.maker.dto.CreateDeveloper;
import com.fastcampus.programming.maker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DMaKerController {
    private final DMakerService dMakerService;

    @GetMapping("/developers")
    public List<String> getAllDevelopers() {

        log.info("GET /developers HTTP/1.1");

        return Arrays.asList("snow", "elsa", "Olaf");

    }

    @PostMapping("/create-developer")
    public List<String> createDeveloper(
            @Valid @RequestBody CreateDeveloper.Request request
    ) {

        log.info("request : {}", request);

        dMakerService.createDeveloper(request);

        return List.of("Olaf");

    }
}

package com.example.dmaker.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/*
 * @author Snow
 */
@Setter
@Getter
@ToString
public class DevDto {
    String name;
    Integer age;
    LocalDateTime startAt;
}

package com.revature.gymapp.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

import java.sql.Timestamp;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkoutLogDto {
    private Long id;
    private UserDto user;
    private WorkoutDto workout;
    private String notes;
    private Boolean completed;
    private Timestamp date;
}

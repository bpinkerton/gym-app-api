package com.revature.gymapp.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.revature.gymapp.api.model.WorkoutPlan;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkoutPlanDto {
    private Long id;
    private UserDto user;
    private WorkoutPlan.Goal goal;
    private WorkoutPlan.Splits splits;
    private Timestamp startDate;
    private Timestamp endDate;
    private List<WorkoutDto> workoutList;
}

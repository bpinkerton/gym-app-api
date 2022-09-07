package com.revature.gymapp.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.revature.gymapp.api.model.WorkoutPlan;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkoutDto {
    private Long id;


    private String category;
    private String description;

    @JsonIgnore
    private List<WorkoutPlan> workoutPlans = new ArrayList<>();
    private List<Integer> exercises;
}

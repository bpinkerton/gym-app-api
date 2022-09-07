package com.revature.gymapp.api.controller;

import com.revature.gymapp.api.dto.WorkoutPlanDto;
import com.revature.gymapp.api.service.WorkoutPlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan")
public class WorkoutPlanController {

    private final WorkoutPlanService workoutPlanService;

    public WorkoutPlanController(WorkoutPlanService workoutPlanService) {
        this.workoutPlanService = workoutPlanService;
    }

    @PostMapping
    public WorkoutPlanDto createWorkoutPlan(@RequestBody WorkoutPlanDto workoutPlanDto){
        return workoutPlanService.createWorkoutPlan(workoutPlanDto);
    }

    @GetMapping
    public List<WorkoutPlanDto> findAllWorkoutPlans(){
        return workoutPlanService.findAllWorkoutPlans();
    }

    @GetMapping("/{id}")
    public WorkoutPlanDto findWorkoutPlanById(@PathVariable Long id){
        return workoutPlanService.findWorkoutPlanById(id);
    }

    @GetMapping("/user/{id}")
    public WorkoutPlanDto findWorkoutPlanByUserId(@PathVariable Long id){
        return workoutPlanService.findWorkoutPlanByUserId(id);
    }

    @PatchMapping("/{id}")
    public WorkoutPlanDto updateWorkoutPlanById(@RequestBody WorkoutPlanDto workoutPlanDto, @PathVariable Long id){
        return workoutPlanService.updateWorkoutPlanById(workoutPlanDto, id);
    }
}

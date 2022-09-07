package com.revature.gymapp.api.controller;

import com.revature.gymapp.api.dto.WorkoutDto;
import com.revature.gymapp.api.service.WorkoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping
    public WorkoutDto createWorkout(@RequestBody WorkoutDto workoutDto){
        return workoutService.createWorkout(workoutDto);
    }

    @GetMapping
    public List<WorkoutDto> findAllWorkouts(){
        return workoutService.findAllWorkouts();
    }

    @GetMapping("/{id}")
    public WorkoutDto findWorkoutById(@PathVariable Long id){
        return workoutService.findWorkoutById(id);
    }

    @PutMapping("/{id}")
    public WorkoutDto replaceWorkoutById(@RequestBody WorkoutDto workoutDto, @PathVariable Long id){
        return workoutService.replaceWorkoutById(workoutDto, id);
    }

    @PatchMapping("/{id}")
    public WorkoutDto updateWorkoutById(@RequestBody WorkoutDto workoutDto, @PathVariable Long id){
        return workoutService.updateWorkoutById(workoutDto, id);
    }
}

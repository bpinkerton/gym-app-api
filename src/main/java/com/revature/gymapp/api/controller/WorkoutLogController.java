package com.revature.gymapp.api.controller;

import com.revature.gymapp.api.dto.WorkoutLogDto;
import com.revature.gymapp.api.service.WorkoutLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log")
@CrossOrigin("*")
public class WorkoutLogController {

    private final WorkoutLogService workoutLogService;

    public WorkoutLogController(WorkoutLogService workoutLogService) {
        this.workoutLogService = workoutLogService;
    }

    @PostMapping
    public WorkoutLogDto createWorkoutLog(@RequestBody WorkoutLogDto workoutLogDto){
        return workoutLogService.createWorkoutLog(workoutLogDto);
    }

    @GetMapping
    public List<WorkoutLogDto> findAllWorkoutLogs(){
        return workoutLogService.findAllWorkoutLogs();
    }

    @GetMapping("/{id}")
    public WorkoutLogDto findWorkoutLogById(@PathVariable Long id){
        return workoutLogService.findWorkoutLogById(id);
    }

    @GetMapping("/user/{id}")
    public List<WorkoutLogDto> findAllWorkoutLogsByUserId(@PathVariable Long id){
        return workoutLogService.findAllWorkoutLogsByUserId(id);
    }
}

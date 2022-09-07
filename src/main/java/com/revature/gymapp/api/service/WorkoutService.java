package com.revature.gymapp.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.gymapp.api.dto.WorkoutDto;
import com.revature.gymapp.api.model.Workout;
import com.revature.gymapp.api.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final ObjectMapper objectMapper;


    public WorkoutService(WorkoutRepository workoutRepository, ObjectMapper objectMapper) {
        this.workoutRepository = workoutRepository;
        this.objectMapper = objectMapper;
    }

    public WorkoutDto createWorkout(WorkoutDto workoutDto){
        Workout workout = objectMapper.convertValue(workoutDto, Workout.class);
        return objectMapper.convertValue(workoutRepository.save(workout), WorkoutDto.class);
    }

    public List<WorkoutDto> findAllWorkouts(){
        return objectMapper.convertValue(workoutRepository.findAll(), new TypeReference<List<WorkoutDto>>() {});
    }

    public WorkoutDto findWorkoutById(Long id){
        return objectMapper.convertValue(workoutRepository.findById(id).orElseThrow(RuntimeException::new), WorkoutDto.class);
    }

    public WorkoutDto replaceWorkoutById(WorkoutDto workoutDto, Long id){
        Workout dbWorkout = objectMapper.convertValue(workoutDto, Workout.class);
        dbWorkout.setId(id);
        return objectMapper.convertValue(workoutRepository.save(dbWorkout), WorkoutDto.class);
    }

    public WorkoutDto updateWorkoutById(WorkoutDto workoutDto, Long id){
        Workout dbWorkout = workoutRepository.findById(id).orElseThrow(RuntimeException::new);

        if(workoutDto.getWorkoutPlans() != null) dbWorkout.setWorkoutPlans(workoutDto.getWorkoutPlans());
        if(workoutDto.getExercises() != null) dbWorkout.setExercises(workoutDto.getExercises());
        if(workoutDto.getCategory() != null) dbWorkout.setCategory(workoutDto.getCategory());
        if(workoutDto.getDescription() != null) dbWorkout.setDescription(workoutDto.getDescription());

        return objectMapper.convertValue(workoutRepository.save(dbWorkout), WorkoutDto.class);
    }
}

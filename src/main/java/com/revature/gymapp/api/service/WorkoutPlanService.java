package com.revature.gymapp.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.gymapp.api.dto.WorkoutPlanDto;
import com.revature.gymapp.api.model.Workout;
import com.revature.gymapp.api.model.WorkoutPlan;
import com.revature.gymapp.api.repository.WorkoutPlanRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WorkoutPlanService {

    private final WorkoutPlanRepository workoutPlanRepository;
    private final ObjectMapper objectMapper;

    public WorkoutPlanService(WorkoutPlanRepository workoutPlanRepository, ObjectMapper objectMapper) {
        this.workoutPlanRepository = workoutPlanRepository;
        this.objectMapper = objectMapper;
    }

    public WorkoutPlanDto createWorkoutPlan(WorkoutPlanDto workoutPlanDto){
        WorkoutPlan workoutPlan = objectMapper.convertValue(workoutPlanDto, WorkoutPlan.class);

        return objectMapper.convertValue(workoutPlanRepository.save(workoutPlan), WorkoutPlanDto.class);
    }

    public List<WorkoutPlanDto> findAllWorkoutPlans() {
        return objectMapper.convertValue(workoutPlanRepository.findAll(), new TypeReference<List<WorkoutPlanDto>>() {});
    }

    public WorkoutPlanDto findWorkoutPlanById(Long id){
        return objectMapper.convertValue(workoutPlanRepository.findById(id).orElseThrow(RuntimeException::new), WorkoutPlanDto.class);
    }

    public WorkoutPlanDto findWorkoutPlanByUserId(Long id){
        return objectMapper.convertValue(workoutPlanRepository.findByUser_Id(id).orElseThrow(RuntimeException::new), WorkoutPlanDto.class);
    }

    public WorkoutPlanDto updateWorkoutPlanById(WorkoutPlanDto workoutPlanDto, Long id){
        WorkoutPlan dbWorkoutPlan = workoutPlanRepository.findById(id).orElseThrow(RuntimeException::new);

        if(workoutPlanDto.getGoal() != null) dbWorkoutPlan.setGoal(workoutPlanDto.getGoal());
        if(workoutPlanDto.getSplits() != null) dbWorkoutPlan.setSplits(workoutPlanDto.getSplits());
        if(workoutPlanDto.getStartDate() != null) dbWorkoutPlan.setStartDate(workoutPlanDto.getStartDate());
        if(workoutPlanDto.getEndDate() != null) dbWorkoutPlan.setEndDate(workoutPlanDto.getEndDate());
        if(workoutPlanDto.getWorkoutList() != null) dbWorkoutPlan.setWorkoutList(
                objectMapper.convertValue(workoutPlanDto.getWorkoutList(), new TypeReference<List<Workout>>() {}));
        return objectMapper.convertValue(workoutPlanRepository.save(dbWorkoutPlan), WorkoutPlanDto.class);
    }
}

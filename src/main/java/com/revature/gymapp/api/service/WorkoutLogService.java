package com.revature.gymapp.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.gymapp.api.dto.WorkoutLogDto;
import com.revature.gymapp.api.model.WorkoutLog;
import com.revature.gymapp.api.repository.WorkoutLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutLogService {

    private final WorkoutLogRepository workoutLogRepository;
    private final ObjectMapper objectMapper;

    public WorkoutLogService(WorkoutLogRepository workoutLogRepository, ObjectMapper objectMapper) {
        this.workoutLogRepository = workoutLogRepository;
        this.objectMapper = objectMapper;
    }

    public WorkoutLogDto createWorkoutLog(WorkoutLogDto workoutLogDto){
        WorkoutLog workoutLog = objectMapper.convertValue(workoutLogDto, WorkoutLog.class);
        return objectMapper.convertValue(workoutLogRepository.save(workoutLog), WorkoutLogDto.class);
    }

    public List<WorkoutLogDto> findAllWorkoutLogs(){
        return objectMapper.convertValue(workoutLogRepository.findAll(), new TypeReference<List<WorkoutLogDto>>() {});
    }

    public WorkoutLogDto findWorkoutLogById(Long id){
        return objectMapper.convertValue(workoutLogRepository.findById(id).orElseThrow(RuntimeException::new), WorkoutLogDto.class);
    }

    public List<WorkoutLogDto> findAllWorkoutLogsByUserId(Long id){
        return objectMapper.convertValue(workoutLogRepository.findAllByUser_Id(id), new TypeReference<List<WorkoutLogDto>>() {});
    }
}

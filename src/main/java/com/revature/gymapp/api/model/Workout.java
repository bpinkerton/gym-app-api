package com.revature.gymapp.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private String description;

    @ManyToMany(mappedBy = "workoutList", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<WorkoutPlan> workoutPlans = new ArrayList<>();

    @ElementCollection
    private List<Integer> exercises;
}

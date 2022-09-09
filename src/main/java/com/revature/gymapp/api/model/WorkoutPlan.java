package com.revature.gymapp.api.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkoutPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    private User user;

    @Enumerated
    private Goal goal;

    @Enumerated
    private Splits splits;

    private Timestamp startDate;
    private Timestamp endDate;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "workout_plan_workouts", joinColumns = @JoinColumn(name="workout_plan_id"), inverseJoinColumns = @JoinColumn(name = "workout_id"))
    private Map<Integer, Workout> workoutList;

    public enum Goal{
        CUTTING, MAINTAINING, BULKING
    }

    public enum Splits{
        ONE(1), TWO(2), THREE(3), FOUR(4),
        FIVE(5), SIX(6), SEVEN(7);

        private final Integer value;
        Splits(Integer value){
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }
}

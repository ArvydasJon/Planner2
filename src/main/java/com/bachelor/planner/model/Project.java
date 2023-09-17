package com.bachelor.planner.model;

import java.time.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Table(name="projects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "projectId")
    private Long projectId;
    @Column(name = "projectName")
    private String projectName;
    @Column(name = "projectDuration")
    private int projectDuration;
    @Column(name = "startDate")
    private LocalDate startDate;
    @Column(name = "endDate")
    private LocalDate endDate;
    @Column(name = "monday")
    private int monday;
    @Column(name = "tuesday")
    private int tuesday;
    @Column(name = "wednesday")
    private int wednesday;
    @Column(name = "thursday")
    private int thursday;
    @Column(name = "friday")
    private int friday;
    @Column(name = "saturday")
    private int saturday;
    @Column(name = "sunday")
    private int sunday;
}

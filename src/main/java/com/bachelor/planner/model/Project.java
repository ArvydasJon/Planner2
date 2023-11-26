package com.bachelor.planner.model;

import java.time.*;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Size;
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
    @Size(min = 2)
    @Column(name = "projectName")
    private String projectName;
    @Min(value=2)
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

package com.bachelor.planner.model;


import java.time.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private Long projectId;
    private String projectName;
    private int projectDuration;
    private LocalDate startDate;
    private LocalDate endDate;

}

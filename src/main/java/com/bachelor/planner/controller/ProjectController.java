package com.bachelor.planner.controller;

import com.bachelor.planner.dto.WeekDaysValueSumData;
import com.bachelor.planner.model.Project;
import com.bachelor.planner.services.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController

public class ProjectController {
    private final ProjectService projectService;

// Žemiau kodas get by Id su try catch
 /*   @GetMapping("/project/{projectId}")

    public ResponseEntity<?> getProject(@PathVariable Long projectId) {
        try {
            if (projectService.getProjectById(projectId) == null) {
                throw new IllegalArgumentException("Netinkamas projekto ID: " + projectId);
                //   throw new IllegalArgumentException();
            }
            //   return ResponseEntity.ok(projectService.getProjectById(projectId));
            return ResponseEntity.ok().body(Map.of("status", HttpStatus.OK.value(), "data", projectService.getProjectById(projectId), "message", "BliaBlia"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Įvyko klaida: " + e.getMessage());
            //  throw new ResponseStatusException(HttpStatus.PAYMENT_REQUIRED,e.getMessage());

        }
    } */

    @GetMapping("/project/{projectId}")
    public Project getProject(@PathVariable Long projectId) {
        return projectService.getProjectById(projectId);
    }


    @GetMapping("/")
    public List<Project> projectList() {
        return projectService.listProjects();
    }

    @PostMapping("/project")
    public String createProject(@Valid  @RequestBody Project project) {
        projectService.addProject(project);
        return "Pavyko";
    }

    @PutMapping("/project/{projectId}")
    public String updateProject(@PathVariable("projectId") Long projectId, @RequestBody Project project) {
        project.setProjectId(projectId);
        projectService.updateProject(project);
        return "Pavyko put";
    }

    @DeleteMapping("/project/{projectId}")
    public String deleteProject(@PathVariable Long projectId) {
        projectService.deleteProject(projectId);
        return "Pavyko delete";
    }

    @GetMapping("/weekday/{projectId}")
    public DayOfWeek getWeekDay(@PathVariable Long projectId) {
        return projectService.getWeekDay(projectId);
    }

  /*  @GetMapping("/weekdayvalue/{projectId}")
    public int getWeekDayValue(@PathVariable Long projectId){
        return  projectService.getWeekDaysValue(projectId);
    } */

  /*  @GetMapping("/weekdaysvaluesum/{projectId}")  // palikau kaip pavyzdį su Pair
    public Pair<Integer, LocalDate> getWeekDayValueSum(@PathVariable Long projectId){
        return  projectService.getWeekDaysValueSum(projectId);
    } */

    // Žemiau du variantai kodo, kurie daro tą patį
    @GetMapping("/weekdaysvaluesum/{projectId}")
    public ResponseEntity<WeekDaysValueSumData> getWeekDaysValueSumWithDate(@PathVariable Long projectId) {
        WeekDaysValueSumData result = projectService.getWeekDaysValueSumWithDate(projectId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/weekdaysvaluesum2/{projectId}")
    public WeekDaysValueSumData getWeekDaysValueSumWithDate2(@PathVariable Long projectId) {
        return projectService.getWeekDaysValueSumWithDate(projectId);
    }


}

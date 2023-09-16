package com.bachelor.planner.controller;

import com.bachelor.planner.model.Project;
import com.bachelor.planner.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController

public class ProjectController {
  private final ProjectService projectService;
    @GetMapping("/project/{projectId}")
    public Project getProject(@PathVariable Long projectId){
       return  projectService.getProjectById(projectId);
    }
    @GetMapping("/")
    public List<Project> projectList(){
      return projectService.listProjects();
    }

    @PostMapping("/project")
    public String createProject(@RequestBody Project project){
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
    public String deleteProject(@PathVariable Long projectId){
        projectService.deleteProject(projectId);
        return "Pavyko delete";
    }

    @GetMapping("/weekday/{projectId}")
    public DayOfWeek getWeekDay(@PathVariable Long projectId){
        return  projectService.getWeekDay(projectId);
    }

  /*  @GetMapping("/weekdayvalue/{projectId}")
    public int getWeekDayValue(@PathVariable Long projectId){
        return  projectService.getWeekDaysValue(projectId);
    } */

    @GetMapping("/weekdaysvaluesum/{projectId}")
    public Pair<Integer, LocalDate> getWeekDayValueSum(@PathVariable Long projectId){
        return  projectService.getWeekDaysValueSum(projectId);
    }

}

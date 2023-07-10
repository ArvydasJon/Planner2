package com.bachelor.planner.controller;

import com.bachelor.planner.model.Project;
import com.bachelor.planner.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
//@RequestMapping("/project")

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

    @PutMapping("/project")
    public String updateProject(@RequestBody Project project){
        projectService.updateProject(project);
        return "Pavyko put";
    }
    @DeleteMapping("/project/{projectId}")
    public String deleteProject(@PathVariable Long projectId){
        projectService.deleteProject(projectId);
        return "Pavyko delete";
    }



}

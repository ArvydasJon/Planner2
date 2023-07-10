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
   //   return new Project(1L,"AA",3, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31));
       return  projectService.getProjectById(projectId);
    }
    @GetMapping("/")
    public List<Project> projectList(){
      return projectService.listProjects();
    }

    @PostMapping("/project")
    public String createProject(@RequestBody Project project){
     //  this.project=project;
        projectService.addProject(project);
        return "Pavyko";
    }

    @PutMapping("/project")
    public String putProject(@RequestBody Project project){
       //this.project=project;
        return "Pavyko put";
    }
    @DeleteMapping("/project/{projectId}")
    public String deleteProject(@PathVariable Long projectId){
        //  this.project=project;
        projectService.deleteProject(projectId);
        return "Pavyko delete";
    }

}

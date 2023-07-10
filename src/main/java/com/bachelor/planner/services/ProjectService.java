package com.bachelor.planner.services;

import com.bachelor.planner.model.Project;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class ProjectService {

    private List<Project> projects = new ArrayList<>();
    private long ID = 0;

    {
        projects.add(new Project(++ID, "AA", 3, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31)));
        projects.add(new Project(++ID, "BB", 3, LocalDate.of(2023, 5, 1), LocalDate.of(2023, 8, 31)));
    }
    public List<Project> listProjects() { return projects; }


    public void addProject(Project project) {
        project.setProjectId(++ID);
        projects.add(project);
    }

    public void deleteProject(Long projectId) {
        projects.removeIf(project -> project.getProjectId().equals(projectId));
    }

    public Project getProjectById(Long id) {
        for (Project project : projects) {
            if (project.getProjectId().equals(id)) return project;
        }
        return null;
    }

}

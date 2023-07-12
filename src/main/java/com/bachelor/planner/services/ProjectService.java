package com.bachelor.planner.services;

import com.bachelor.planner.model.Project;
import com.bachelor.planner.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    public List<Project> listProjects() {
        List<Project> projects= projectRepository.findAll();
        return projects;
    }
    public Project getProjectById(Long id) {

        return projectRepository.findById(id).orElse(null);
    }
    public void addProject(Project project) {
    projectRepository.save(project);
    }

    public void updateProject(Project project) {
        projectRepository.save(project);
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
 /*   private List<Project> projects = new ArrayList<>();
    private long ID = 0;

    {
        projects.add(new Project(++ID, "AA", 3, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31)));
        projects.add(new Project(++ID, "BB", 3, LocalDate.of(2023, 5, 1), LocalDate.of(2023, 8, 31)));
    }
    public List<Project> listProjects() { return projects; }

*/
 /*   public void addProject(Project project) {
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

    public void updateProject(Project project) {
        for (int i = 0; i < projects.size(); i++) {
            Project p = projects.get(i);
            if (p.getProjectId().equals(project.getProjectId())) {
                projects.set(i, project);
                break;
            }
        }
    }


*/

    }



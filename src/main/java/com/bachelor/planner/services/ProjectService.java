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

    }



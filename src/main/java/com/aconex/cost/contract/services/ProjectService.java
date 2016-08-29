package com.aconex.cost.contract.services;

import com.aconex.cost.contract.models.Contract;
import com.aconex.cost.contract.models.Project;
import com.aconex.cost.contract.repositories.ContractRepository;
import com.aconex.cost.contract.repositories.ProjectRepository;

import java.util.List;

public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project getProject(long id) {
        return projectRepository.getProject(id);
    }

    public List<Project> findProjectByCode(String code) {
        return projectRepository.findProjectByCode(code);
    }

    public Project saveOrUpdate(Project project) {
        return projectRepository.saveOrUpdate(project);
    }

    public void deleteProject(long id) {
        projectRepository.deleteProject(id);
    }
}

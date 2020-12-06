package edu.tum.ase.project.service;

import edu.tum.ase.project.model.Project;
import edu.tum.ase.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(String name) {
        Project project = new Project(name);
        projectRepository.save(project);
        return project;
    }

    // probably to be removed. Nice for testing
    public Project deleteProjectByName(String projectName) {
        Project project = projectRepository.findByName(projectName);
        projectRepository.delete(project);
        return project;
    }

    public String deleteProjectById(String projectId) {
        projectRepository.deleteById(projectId);
        return projectId;
    }

    public Project findByName(String name) {
        return projectRepository.findByName(name);
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Project updateProject(Project project){

        // potentially project does not exist. TODO: check error handling here
        Project projectToUpdate = projectRepository.getOne(project.getId());

        // potentially duplicate name. TODO: check error handling here
        projectToUpdate.setName(project.getName());

        projectRepository.save(projectToUpdate);

        return projectToUpdate;
    }

}
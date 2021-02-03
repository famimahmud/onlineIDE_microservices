package edu.tum.ase.project.controller;

import edu.tum.ase.project.model.Project;
import edu.tum.ase.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    // Projekt erstellen
    @RequestMapping(path = "/api/projects", method = RequestMethod.POST)
    public Project createProject(@RequestBody String name) throws IOException {
        return projectService.createProject(name);
    }

    // Projekt löschen
    @RequestMapping(path = "/api/projects/{id}", method = RequestMethod.DELETE)
    public String deleteProjectById(@PathVariable String id) throws IOException {
        return projectService.deleteProjectById(id);
    }

    // Projekt updaten
    @RequestMapping(path = "/api/projects", method = RequestMethod.PUT)
    public Project updateProject(@RequestBody Project project) throws IOException {
        return projectService.updateProject(project);
    }

    // Alle projekte auflisten
    @RequestMapping(path = "/api/projects/all", method = RequestMethod.GET)
    public List<Project> listAllProjects() throws IOException {
        return projectService.getProjects();
    }

}

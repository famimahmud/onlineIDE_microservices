package edu.tum.ase.project.controller;

import edu.tum.ase.project.model.Project;
import edu.tum.ase.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    // Projekt erstellen
    @RequestMapping(path = "/projects", method = RequestMethod.POST)
    public Project createProject(@RequestParam String name) throws IOException {
        return projectService.createProject(name);
    }

    // Projekt löschen mit Namen
    @RequestMapping(path = "/projectsByName", method = RequestMethod.DELETE)
    public Project deleteProjectByName(@RequestParam String name) throws IOException {
        return projectService.deleteProjectByName(name);
    }

    // Projekt löschen
    @RequestMapping(path = "/projects", method = RequestMethod.DELETE)
    public String deleteProjectById(@RequestParam String id) throws IOException {
        return projectService.deleteProjectById(id);
    }

    // Projekt updaten
    @RequestMapping(path = "/projects", method = RequestMethod.PUT)
    public Project updateProject(@RequestBody Project project) throws IOException {
        return projectService.updateProject(project);
    }

    // Alle projekte auflisten
    @RequestMapping(path = "/projects/all", method = RequestMethod.GET)
    public List<Project> listAllProjects() throws IOException {
        return projectService.getProjects();
    }


    // get Project by name
    @RequestMapping(path = "/projects", method = RequestMethod.GET)
    public Project findProjectByName(@RequestParam String name) throws IOException {
        return projectService.findByName(name);
    }
}

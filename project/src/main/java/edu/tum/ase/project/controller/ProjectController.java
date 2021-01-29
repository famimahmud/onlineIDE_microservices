package edu.tum.ase.project.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.tum.ase.project.model.Project;
import edu.tum.ase.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    // Projekt erstellen
    @RequestMapping(path = "/projects", method = RequestMethod.POST)
    public Project createProject(@RequestBody String name) throws IOException {
        return projectService.createProject(name);
    }
    /*
    TODO: delete if obsolete -> option to receive current user from UI - UI needs to be informed who is using it then
    @RequestMapping(path = "/projects", method = RequestMethod.POST)
    public Project createProject(@RequestBody ObjectNode body) throws IOException {
        Set<String> users = new HashSet<>();
        users.add(body.get("users").asText());
        System.out.println(body.get("users").asText());
        return projectService.createProject(body.get("name").asText(), users);
    }*/

    // Projekt löschen mit Namen
    @RequestMapping(path = "/projectsByName", method = RequestMethod.DELETE)
    public Project deleteProjectByName(@RequestBody String name) throws IOException {
        return projectService.deleteProjectByName(name);
    }

    // Projekt löschen
    @RequestMapping(path = "/projects/{id}", method = RequestMethod.DELETE)
    public String deleteProjectById(@PathVariable String id) throws IOException {
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
    public Project findProjectByName(@RequestBody String name) throws IOException {
        return projectService.findByName(name);
    }
}

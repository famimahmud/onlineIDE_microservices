package edu.tum.ase.project.service;


import edu.tum.ase.project.model.Project;
import edu.tum.ase.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
//@Profile("dev")
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired UserDetailsService userDetailsService;

    public Project createProject(String name) {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Principal current = securityContext.getAuthentication();

        Set<String> users = new HashSet<String>();
        users.add(current.getName());

        // create a new project
        Project project = new Project(name, users);
        projectRepository.save(project);
        return project;
    }

    public String deleteProjectById(String projectId) {
        projectRepository.deleteById(projectId);
        return projectId;
    }


    public List<Project> getProjects() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Principal current = securityContext.getAuthentication();

        return projectRepository.findAll().stream()
                .filter(p -> p.getUsers().contains(current.getName()))
                .collect(Collectors.toList());
    }

    public Project updateProject(Project project){
        // TODO: check if user exists
//        Set<String> foundUsers = new HashSet<>();
//        for (String user: project.getUsers()) {
//
//            if (check here) {
//                foundUsers.add(user);
//            }
//        }

        Project projectToUpdate = projectRepository.getOne(project.getId());

//        projectToUpdate.setUsers(foundUsers);

        projectToUpdate.setName(project.getName());
        projectToUpdate.setUsers(project.getUsers());
        projectRepository.save(projectToUpdate);
        return projectToUpdate;
    }


}

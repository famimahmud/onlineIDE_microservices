package edu.tum.ase.project;

import edu.tum.ase.project.model.Project;
import edu.tum.ase.project.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(ProjectApplication.class);

    @Autowired
    private ProjectService projectService;
    private DataSource dataSource;
    //private DataSource dataSource = projectService.dataSource();

    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("DataSource = " + dataSource);
        List<Project> projects = projectService.getProjects();
        log.info("Project List " + projects);
    }
}

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
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
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
        //Project p1 = projectService.createProject("test project 1");
        //Project p2 = projectService.createProject("test project 2");
        //log.info(String.format("Projects with ids: %s and %s saved.", p1.getId(), p2.getId()));
        //log.info(projectService.deleteProjectById("ff80818176e649d30176e649d5020000"));
        List<Project> projects = projectService.getProjects();
        log.info("Project List " + projects);
    }
}

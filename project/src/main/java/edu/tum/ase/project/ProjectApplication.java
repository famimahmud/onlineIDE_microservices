package edu.tum.ase.project;

import edu.tum.ase.project.model.Project;
import edu.tum.ase.project.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
public class ProjectApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

//
}

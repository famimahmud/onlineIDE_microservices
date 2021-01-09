package edu.tum.ase.project.service;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.tum.ase.project.model.Project;
import edu.tum.ase.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@Profile("dev")
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
        Project projectToUpdate = projectRepository.getOne(project.getId());

        // potentially duplicate name. TODO: check error handling here <- einfach so wie mit den schleifen und -1 machen und dann beim Namen (2) oder ähnlich dran hängen
        projectToUpdate.setName(project.getName());

        projectRepository.save(projectToUpdate);

        return projectToUpdate;
    }

    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Value("${spring.datasource.name}")
    private String dbName;

    @Value("${spring.datasource.username}")
    private String dbUserName;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${database.port}")
    private String dbPort;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        if (jdbcUrl.isEmpty()) {
            config.setJdbcUrl("jdbc:postgresql://localhost:" + dbPort + "/" + dbName);
            config.setUsername(dbUserName);
            config.setPassword(dbPassword);
        } else {
            config.setJdbcUrl(jdbcUrl);
            config.setUsername(dbUserName);
            config.setPassword(dbPassword);
        }
        return new HikariDataSource(config);
    }

}

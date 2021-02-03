package edu.tum.ase.project.service;

import edu.tum.ase.project.model.Project;
import edu.tum.ase.project.model.SourceFile;
import edu.tum.ase.project.repository.ProjectRepository;
import edu.tum.ase.project.repository.SourceFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


import java.util.List;

@Configuration
//@Profile("dev")
@Service
public class SourceFileService {

    @Autowired
    private SourceFileRepository sourceFileRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public SourceFile addSourceFile(String name, String sourceCode, String projectId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        if (null == project) {
            //throw error no such project TODO
        }
        return sourceFileRepository.save(new SourceFile(name, sourceCode, project));
    }

    public SourceFile findByName(String name) {
        return sourceFileRepository.findByName(name);
    }

    public List<SourceFile> findListByProjectId(String projectId) {
        return sourceFileRepository.findAllByProjectId(projectId);
    }


    public String deleteSourceFileById(String sourceFileId) {
        sourceFileRepository.deleteById(sourceFileId);
        return sourceFileId;
    }

    public SourceFile updateSourceFile(SourceFile sourceFile) {

        // potentially sourceFile does not exist. TODO: check error handling here
        SourceFile sourceFileToUpdate = sourceFileRepository.findById(sourceFile.getId()).get();

        // potentially duplicate name. TODO: check error handling here
        sourceFileToUpdate.setName(sourceFile.getName());
        sourceFileToUpdate.setSourceCode(sourceFile.getSourceCode());


        sourceFileRepository.save(sourceFileToUpdate);

        return sourceFileToUpdate;
    }

}

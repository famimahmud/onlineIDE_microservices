package edu.tum.ase.project.controller;

import edu.tum.ase.project.model.Project;
import edu.tum.ase.project.model.SourceFile;
import edu.tum.ase.project.service.SourceFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class SourceFileController {
    @Autowired
    private SourceFileService sourceFileService;

    // Sourcefile erstellen
    @RequestMapping(path = "/api/projects/{projectId}/source_files", method = RequestMethod.POST)
    public SourceFile createSourceFile(@RequestBody Map<String, String> new_file, @PathVariable String projectId) throws IOException {
        return sourceFileService.addSourceFile(new_file.get("name"), new_file.get("sourceCode"), projectId);
    }

    // Sourcefiles für Projekt abrufen
    @RequestMapping(path = "/api/projects/{projectId}/source_files", method = RequestMethod.GET)
    public List<SourceFile> getSourceFiles(@PathVariable String projectId) throws IOException {
        return sourceFileService.findListByProjectId(projectId);
    }

    // delete by id
    @RequestMapping(path = "/api/projects/{projectId}/source_files/{id}", method = RequestMethod.DELETE)
    public String deleteSourceFileById(@PathVariable String projectId, @PathVariable String id ) throws IOException {
        return sourceFileService.deleteSourceFileById(id);
    }

    // update by id
    @RequestMapping(path = "/api/projects/{projectId}/source_files", method = RequestMethod.PUT)
    public SourceFile updateSourceFile(@RequestBody SourceFile sourceFile, @PathVariable String projectId) throws IOException {
        System.out.println(sourceFile);
        return sourceFileService.updateSourceFile(sourceFile);
    }
}

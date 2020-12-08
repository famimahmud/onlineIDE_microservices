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
    @RequestMapping(path = "/projects/{projectId}/source_files", method = RequestMethod.POST)
    public SourceFile createSourceFile(@RequestBody Map<String, String> json, @PathVariable String projectId) throws IOException {
        return sourceFileService.addSourceFile(json.get("name"), json.get("sourceCode"), projectId);
    }

    // Sourcefiles für Projekt abrufen
    @RequestMapping(path = "/projects/{projectId}/source_files", method = RequestMethod.GET)
    public List<SourceFile> getSourceFiles(@PathVariable String projectId) throws IOException {
        return sourceFileService.findListByProjectId(projectId);
    }

    // delete by id
    @RequestMapping(path = "/projects/{projectId}/source_files", method = RequestMethod.DELETE)
    public String deleteSourceFileById(@RequestBody String id, @PathVariable String projectId) throws IOException {
        return sourceFileService.deleteSourceFileById(id);
    }

    // update by id
    @RequestMapping(path = "/projects/{projectId}/source_files", method = RequestMethod.PUT)
    public SourceFile updateSourceFile(@RequestBody SourceFile sourceFile, @PathVariable String projectId) throws IOException {
        return sourceFileService.updateSourceFile(sourceFile);
    }
}

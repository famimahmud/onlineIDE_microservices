package edu.tum.ase.compiler.service;

import edu.tum.ase.compiler.model.SourceCode;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class CompilerService {
    public SourceCode compile(SourceCode sourceCode) throws IOException {
        sourceCode.setStdout("");
        boolean error = false;
        // Programmiersprache für Compiler anhand Extension ermitteln
        String fileName = sourceCode.getFileName();
        String language = "";
        int index = fileName.lastIndexOf('.');
        if (index > 0) {
            language = fileName.substring(index + 1);
        }
        String compiler = null;

        if (language.equals("java")) {
            compiler = "javac";
        } else if (language.equals("c")) {
            compiler = "gcc";
        } else {
            sourceCode.setStderr("This language is not supported!");
            return sourceCode;
        }

        try {
            //SourceCode in Datei schreiben, die kompiliert werden kann
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            writer.write(sourceCode.getCode());
            writer.flush();
            writer.close();

            //Datei kompilieren
            String command = compiler + " " + file.getAbsolutePath();
            Process p = Runtime.getRuntime().exec(command);

            //Fehlermeldungen prüfen und ggf. in stderr speichern
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String stderr = "\n...\n";
            String log = null;
            while ((log = stdError.readLine()) != null) {
                stderr += log + "\n";
                error = true;
            }
            if (!error) {
                sourceCode.setCompilable(true);
                sourceCode.setStdout("Compilation was successful!");
                sourceCode.setStderr("");
            } else {
                sourceCode.setStderr(stderr);
            }

            //evtl. sollte man hier noch die generierten Dateien löschen
            //evtl. würde das Sinn ergeben:) (Kommentar von 12.01.2020)

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!error) {
            assert sourceCode.getStdout() == "Compilation was successful!";
        } else {
            assert sourceCode.getStderr() == "";
        }
        return sourceCode;
    }

}

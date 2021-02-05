package edu.tum.ase.compiler.service;

import edu.tum.ase.compiler.model.SourceCode;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        String executer = null;
        if (language.equals("java")) {
            compiler = "javac";
            executer = "java" + " " + fileName.substring(0, fileName.length() - 5);
        } else if (language.equals("c")) {
            compiler = "gcc";
            executer = "./a.out";

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
                sourceCode.setStdout("Compilation was successful! " + System.lineSeparator());
                sourceCode.setStderr("");
            } else {
                sourceCode.setStderr(stderr);
            }
            String path = file.getAbsolutePath();
            path = path.substring(0, path.length()- fileName.length());

            file.delete();
            if (!error) {
                Process p2 = Runtime.getRuntime().exec(executer);
                BufferedReader output = new BufferedReader(new InputStreamReader(p2.getInputStream()));
                String output2 = "";
                String line = null;
                while ((line = output.readLine()) != null) {
                    output2 += line + System.lineSeparator();
                }
                sourceCode.alterStdout(output2);

                String compiledFile = fileName;
                if (language.equals("java")) {
                    compiledFile = compiledFile.substring(0, compiledFile.length()-4);
                    compiledFile += "class";
                    path += compiledFile;
                }
                if (language.equals("c")) {
                    path += "a.out";
                }
                Path path1 = Paths.get(path);
                Files.deleteIfExists(path1);
            }

            //evtl. sollte man hier noch die generierten Dateien löschen
            //evtl. würde das Sinn ergeben:) (Kommentar von 12.01.2020)
            //Generierte Dateien werden jetzt direkt wieder gelöscht (Kommentar von 29.01)
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!error) {
            assert sourceCode.getStdout().startsWith("Compilation was successful!");
        } else {
            assert sourceCode.getStderr() == "";
        }
        return sourceCode;
    }

}

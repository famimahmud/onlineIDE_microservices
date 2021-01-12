package edu.tum.ase.compiler.unit;

import edu.tum.ase.compiler.model.SourceCode;
import edu.tum.ase.compiler.service.CompilerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
public class CompilerControllerTest {

    @Autowired
    private CompilerService systemUnderTest;

    @Test
    public void should_ReturnStdError_When_UnknownFileFormat() throws IOException {
        SourceCode sourceCode = new SourceCode();
        sourceCode.setFileName("file.py");
        sourceCode.setCode("");

        assertEquals("This language is not supported!", systemUnderTest.compile(sourceCode).getStderr());
    }

    @Test
    public void should_ReturnEmptyStdError_When_JavaFileFormat() throws IOException {
        SourceCode sourceCode = new SourceCode();
        sourceCode.setFileName("file.java");
        sourceCode.setCode("");

        assertEquals("", systemUnderTest.compile(sourceCode).getStderr());
    }

    @TestConfiguration
    static class ProjectControllerTestsConfiguration {

        @Bean
        public CompilerService systemUnderTest() {
            return new CompilerService();
        }
    }

}
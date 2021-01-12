package edu.tum.ase.compiler.it;

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
public class CompilerServiceTestIT {

    @Autowired
    private CompilerService systemUnderTest;

    @Test
    public void should_ReturnCorrectResult_When_JavaFileCompiledSuccefully() throws IOException {
        SourceCode sourceCode = new SourceCode();
        sourceCode.setFileName("App.java");
        sourceCode.setCode("public class App { public static void main(String[] args) {System.out.println(\"Hello World!\");}}");

        assertEquals("Compilation was successful!", systemUnderTest.compile(sourceCode).getStdout());
        assertEquals(true, systemUnderTest.compile(sourceCode).isCompilable());

    }

    @TestConfiguration
    static class ProjectControllerTestsConfiguration {

        @Bean
        public CompilerService systemUnderTest() {
            return new CompilerService();
        }
    }

}
package edu.tum.ase.compiler.e2e;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tum.ase.compiler.model.SourceCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompilerE2ERESTTests {


    private final String URL = "/compile/";

    @Autowired
    private MockMvc systemUnderTest;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void should_ReturnPersistedProject_When_PostWithProject() throws Exception {
        // given
        SourceCode sourceCode = new SourceCode();
        sourceCode.setFileName("App.java");
        sourceCode.setCode("public class App { public static void main(String[] args) {System.out.println(\"Hello World!\");}}");

        // when
        ResultActions result = systemUnderTest.perform(post(URL)
                .content(objectMapper.writeValueAsString(sourceCode))
                .contentType(MediaType.APPLICATION_JSON));

//         then
         result
                        .andExpect(status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.compilable").value(true))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.stdout").value("Compilation was successful!"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.stderr").value(""))
         ;
//
    }

}
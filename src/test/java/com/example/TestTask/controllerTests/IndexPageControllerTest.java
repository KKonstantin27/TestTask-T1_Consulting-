package com.example.TestTask.controllerTests;

import com.example.TestTask.controllers.IndexPageController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(value = IndexPageController.class)
public class IndexPageControllerTest {
    private final MockMvc mockMvc;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public IndexPageControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void getIndexPageShouldReturnIndexView() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/"))
                .andExpect(content().contentType(MediaType.valueOf("text/html;charset=UTF-8")))
                .andExpect(view().name("index"))
                .andExpect(status().is(200));
    }

}

package com.example.TestTask.controllerTests;

import com.example.TestTask.controllers.CounterPageController;
import com.example.TestTask.dtos.StringQueryDTO;
import com.example.TestTask.services.CountCharactersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(value = {CounterPageController.class, CountCharactersService.class})
public class CounterPageControllerTest {

    private final MockMvc mockMvc;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public CounterPageControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void validStringQueryShouldReturnResponseJSONWith200() throws Exception {
        StringQueryDTO stringQueryDTO = new StringQueryDTO("111ЖAAAAAbbbb..");

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/count")
                        .param("StringQuery", stringQueryDTO.getStringQuery())
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }

    @Test
    public void emptyStringQueryShouldReturnErrorJSONWith400() throws Exception {
        StringQueryDTO stringQueryDTO = new StringQueryDTO();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/count")
                        .param("StringQuery", stringQueryDTO.getStringQuery())
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));
    }

    @Test
    public void longStringQueryShouldReturnErrorJSONWith400() throws Exception {
        char[] stringQueryCharArr = new char[101];
        Arrays.fill(stringQueryCharArr, 'a');
        StringQueryDTO stringQueryDTO = new StringQueryDTO(Arrays.toString(stringQueryCharArr));

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/count")
                        .param("StringQuery", stringQueryDTO.getStringQuery())
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));
    }
}

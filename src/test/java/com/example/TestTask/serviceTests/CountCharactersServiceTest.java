package com.example.TestTask.serviceTests;

import com.example.TestTask.services.CountCharactersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest(classes = CountCharactersService.class)
public class CountCharactersServiceTest {

    private final CountCharactersService countCharactersService;

    @Autowired
    public CountCharactersServiceTest(CountCharactersService countCharactersService) {
        this.countCharactersService = countCharactersService;
    }

    @Test
    public void countCharactersShouldReturnSortedMap() throws JsonProcessingException, JSONException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<Character, Long> sortedCharCounts = countCharactersService.countCharacters("111ЖAAAAAbbbb..");
        String jacksonData = objectMapper.writeValueAsString(sortedCharCounts);
        JSONAssert.assertEquals("{\"A\":5,\"b\":4,\"1\":3,\".\":2,\"Ж\":1}", jacksonData, true);
    }
}

package com.example.TestTask.controllers;

import com.example.TestTask.dtos.StringQueryDTO;
import com.example.TestTask.services.CountCharactersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CounterPageController {

    private final CountCharactersService countCharactersService;

    @Autowired
    public CounterPageController(CountCharactersService countCharactersService) {
        this.countCharactersService = countCharactersService;
    }

    @PostMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> countCharacters(@ModelAttribute("StringQueryDTO") @Valid StringQueryDTO stringQueryDTO,
                                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult
                    .getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();

            return ResponseEntity.badRequest().body(errorMessages);
        }

        Map<Character, Long> sortedCharCounts = countCharactersService.countCharacters(stringQueryDTO.getStringQuery());

        return ResponseEntity.ok().body(sortedCharCounts);
    }
}

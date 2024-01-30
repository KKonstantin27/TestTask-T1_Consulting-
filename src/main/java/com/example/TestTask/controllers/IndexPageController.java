package com.example.TestTask.controllers;

import com.example.TestTask.dtos.StringQueryDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class IndexPageController {
    @GetMapping("/")
    public String getIndexPage(@ModelAttribute("StringQueryDTO") StringQueryDTO stringQueryDTO) {
        return "index";
    }
}
